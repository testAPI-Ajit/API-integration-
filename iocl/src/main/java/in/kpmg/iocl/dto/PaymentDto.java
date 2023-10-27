package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class PaymentDto {

    private Integer service;
    @JsonProperty("I_FROM_DATE")
    private String I_FROM_DATE;
    @JsonProperty("I_TO_DATE")
    private String I_TO_DATE;
    @JsonProperty("WERKS")
    private String WERKS;
}
