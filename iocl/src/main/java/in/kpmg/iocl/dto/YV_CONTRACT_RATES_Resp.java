package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class YV_CONTRACT_RATES_Resp {
    @JsonProperty("I_BUKRS")
    private YV_CONTRACT_RATES_I_BUKRS I_BUKRS;
    @JsonProperty("I_MATGRP")
    private String I_MATGRP;
    @JsonProperty("I_RTDCLUST")
    private String I_RTDCLUST;
    @JsonProperty("I_TPLST")
    private I_TPLST I_TPLST;
    @JsonProperty("O_REPORT")
    private O_REPORT O_REPORT;
}
