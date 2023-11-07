package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EtExchRateItems {
    @JsonProperty("MANDT")
    private String MANDT;
    @JsonProperty("KURST")
    private String KURST;
    @JsonProperty("FCURR")
    private String FCURR;
    @JsonProperty("TCURR")
    private String TCURR;
    @JsonProperty("GDATU")
    private String GDATU;
    @JsonProperty("UKURS")
    private String UKURS;
    @JsonProperty("FFACT")
    private String FFACT;
    @JsonProperty("TFACT")
    private String TFACT;
}
