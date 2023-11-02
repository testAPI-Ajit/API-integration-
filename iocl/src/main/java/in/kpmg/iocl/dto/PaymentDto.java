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
    @JsonProperty("I_DIVISION")
    private String I_DIVISION;
    @JsonProperty("WERKS")
    private String WERKS;
    @JsonProperty("SIGN")
    private String SIGN;
    @JsonProperty("OPTION")
    private String OPTION;
    @JsonProperty("LOW")
    private String LOW;
    @JsonProperty("HIGH")
    private String HIGH;
    @JsonProperty("DOCUMENT_TYPE")
    private String DOCUMENT_TYPE;
    @JsonProperty("MATERIAL_TYPE")
    private String MATERIAL_TYPE;
    @JsonProperty("PLANT")
    private String PLANT;
    @JsonProperty("I_ALL_BOMM")
    private String I_ALL_BOMM;
    @JsonProperty("I_MAINBOM_ONLY")
    private String I_MAINBOM_ONLY;
    @JsonProperty("I_AS_ON_DATE")
    private String I_AS_ON_DATE;
}
