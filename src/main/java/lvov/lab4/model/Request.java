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
    /**
     * Уникальный идентификатор сообщения.
     */
    @NotBlank(message = "Не заполнено поле uid")
    @Size(max = 32, message = "uid не более 32 символов")
    private String uid;

    /**
     * Уникальный идентификатор операции.
     */
    @NotBlank(message = "не заполнено поле operationUid")
    @Size(max = 32, message = "uid не более 32 символов")
    private String operationUid;

    /**
     * Имя системы.
     */
    private String systemName;

    /**
     * Системное время.
     */
    @NotBlank(message = "нет системного времени")
    private String systemTime;

    /**
     * Источник запроса.
     */
    private String source;

    /**
     * Должность сотрудника.
     */
    private Positions positions;

    /**
     * Заработная плата сотрудника.
     */
    private Double salary;

    /**
     * Бонус сотрудника.
     */
    private Double bonus;

    /**
     * Количество рабочих дней.
     */
    private int workDays;

    /**
     * Идентификатор коммуникации.
     */
    @Min(value = 1, message = "communicationId должен быть не менее 1")
    @Max(value = 100000, message = "communicationId должен быть не более 100000")
    private int communicationId;

    /**
     * Идентификатор шаблона.
     */
    private int templateId;

    /**
     * Код продукта.
     */
    private int productCode;

    /**
     * Код SMS.
     */
    private int smsCode;

    /**
     * Переопределение метода toString() для удобного вывода объекта в виде строки.
     */
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
