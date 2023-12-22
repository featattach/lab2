package lvov.lab4.model;

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
    @NotBlank(message = "Не заполнено поле uid")
    @Size(max = 32, message = "uid не более 32 символов")
    private String uid;
    @NotBlank(message = "не заполнено поле operationUid")
    @Size(max = 32, message = "uid не более 32 символов")
    private String operationUid;
    private String systemName;
    @NotBlank(message = "нет системного времни")
    private String systemTime;
    private String source;
    private Positions positions;
    private Double salary;
    private Double bonus;
    private int workDays;

    @Min(value = 1, message = "communicationId должен быть не менее 1")
    @Max(value = 100000, message = "communicationId должен быть не более 100000")
    private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;

    @Override
    public String toString(){
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId='" + communicationId +
                ", templateId" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }


}
