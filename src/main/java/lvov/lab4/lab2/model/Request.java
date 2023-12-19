package lvov.lab4.lab2.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Request {
    @NotBlank
    @Size(max = 32, message = "uid не более 32 символов")
    private String uid;
    @NotBlank
    @Size(max = 32, message = "uid не более 32 символов")
    private String operationUid;
    private String systemName;
    @NotBlank
    private String systemTime;
    private String source;

    @Min(value = 1, message = "communicationId должен быть не менее 1")
    @Max(value = 100000, message = "communicationId должен быть не более 100000")
    private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;

}
