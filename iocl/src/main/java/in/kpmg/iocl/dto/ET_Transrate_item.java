package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ET_Transrate_item {
    @JsonProperty("MANDT")
    private Integer MANDT;
    @JsonProperty("WERKS")
    private Integer WERKS;
    @JsonProperty("VEH_TYPE")
    private String VEH_TYPE;
    @JsonProperty("TU_NUMBER")
    private String TU_NUMBER;
    @JsonProperty("BZIRK")
    private String BZIRK;
     @JsonProperty("KUNNR")
    private String KUNNR;
    @JsonProperty("YYRATE_APPLIC")
    private Integer YYRATE_APPLIC;
    @JsonProperty("BEGDA")
    private String BEGDA;
    @JsonProperty("ENDDA")
    private String ENDDA;
    @JsonProperty("YYBASE_RATE")
    private String YYBASE_RATE;
    @JsonProperty("PROVISIONAL")
    private String PROVISIONAL;
    @JsonProperty("REMARKS")
    private String REMARKS;
}
