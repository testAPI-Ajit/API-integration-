package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class YV_TPT_CUSTRTD_Response {
    @JsonProperty("EMSG")
    private String EMSG;
    @JsonProperty("I_TPT_CUSTRTD")
    private I_TPT_CUSTRTD I_TPT_CUSTRTD;
    @JsonProperty("I_BUKRS")
    private I_BUKRS I_BUKRS;
    @JsonProperty("I_WERKS")
    private I_WERKS I_WERKS;

}
