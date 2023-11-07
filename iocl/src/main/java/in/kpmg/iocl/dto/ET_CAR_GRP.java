package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.json.JSONPropertyIgnore;

@Data
public class ET_CAR_GRP {
    @JsonProperty("MANDT")
    private Integer MANDT;
    @JsonProperty("WERKS")
    private Integer WERKS;
    @JsonProperty("YYCARTON_GRP")
    private String YYCARTON_GRP;
    @JsonProperty("BEGDA")
    private String BEGDA;
    @JsonProperty("ENDDA")
    private String ENDDA;
    @JsonProperty("WGT_FROM")
    private String WGT_FROM;
    @JsonProperty("WGT_TO")
    private String WGT_TO;
    @JsonProperty("YYRATE_PERCENT")
    private String YYRATE_PERCENT;
}
