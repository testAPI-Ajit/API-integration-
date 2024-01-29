package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class I_WERKS_Item {
    @JsonProperty("MANDT")
    private String MANDT;
    @JsonProperty("WERKS")
    private String WERKS;
}
