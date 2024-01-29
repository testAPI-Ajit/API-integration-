package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class I_TPLST_Item {
    @JsonProperty("TPLST_SIGN")
    private String TPLST_SIGN;
    @JsonProperty("TPLST_OPTION")
    private String TPLST_OPTION;
    @JsonProperty("TPLST_LOW")
    private String TPLST_LOW;
    @JsonProperty("TPLST_HIGH")
    private String TPLST_HIGH;
}
