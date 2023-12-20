package lvov.lab4.lab2.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lvov.lab4.lab2.exception.UnsupportedCodeException;
import lvov.lab4.lab2.exception.ValidationFailedException;
import lvov.lab4.lab2.model.*;
import lvov.lab4.lab2.service.ModifyResponseService;
import lvov.lab4.lab2.service.ValidationService;
import lvov.lab4.lab2.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class MyController {


    private final ModifyResponseService modifyResponseService;
    private final ValidationService validationService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;

    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        log.info("request: {}", request);
// Записываем время получения исходного запроса в Сервисе 2
        long startTime = System.currentTimeMillis();

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        try {
            validationService.isValid(bindingResult);
            // Проверка на uid равный 123
            if ("123".equals(request.getUid())) {
                log.error("Received request with unsupported code: 123");
                throw new UnsupportedCodeException("Unsupported code: 123");
            }
        } catch (ValidationFailedException e) {
            log.error("Validation failed: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            log.error("Unsupported code: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            log.error("Unsupported code: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        long endTime =System.currentTimeMillis();
        log.info("Time taken to process original request: {} ms", endTime - startTime);

        startTime = System.currentTimeMillis();
        long endTimeModified = System.currentTimeMillis();
        log.info("Time taken to process modified request: {} ms", endTimeModified - startTime);

        Response modifiedResponse = modifyResponseService.modify(response);
        log.info("Sending response: {}", modifiedResponse);
        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
}
