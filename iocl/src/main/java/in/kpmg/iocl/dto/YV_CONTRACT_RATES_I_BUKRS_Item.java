package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class YV_CONTRACT_RATES_I_BUKRS_Item {
    @JsonProperty("SIGN")
       private String SIGN;
    @JsonProperty("OPTION")
    private String OPTION;
    @JsonProperty("LOW")
    private String LOW;
            @JsonProperty("HIGH")
    private String HIGH;
}
