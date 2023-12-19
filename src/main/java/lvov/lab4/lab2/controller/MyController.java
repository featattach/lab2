package lvov.lab4.lab2.controller;

import jakarta.validation.Valid;
import lvov.lab4.lab2.exception.UnsupportedCodeException;
import lvov.lab4.lab2.exception.ValidationFailedException;
import lvov.lab4.lab2.model.Request;
import lvov.lab4.lab2.model.Response;
import lvov.lab4.lab2.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.Bidi;

@RestController
public class MyController {
    private final ValidationService validationService;
    @Autowired
    public MyController(ValidationService validationService){
        this.validationService = validationService;
    }
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        try{
            validationService.isValid(bindingResult);
            // Проверка на uid равный 123
            if ("123".equals(request.getUid())) {
                throw new UnsupportedCodeException("Unsupported code: 123");
            }
        } catch (ValidationFailedException e){
            response.setCode("failed");
            response.setErrorCode("ValidationException");
            response.setErrorMessage("Ошибка валидации");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            response.setCode("failed");
            response.setErrorCode("UnknownException");
            response.setErrorMessage("Произошла непредвиденная ошибка");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
