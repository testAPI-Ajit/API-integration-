package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class E_GRADEMAST_LG_Item {
    @JsonProperty("MANDT")
    String MANDT;
    @JsonProperty("YGRADECD")
    String YGRADECD;
    @JsonProperty("YGRDESC")
    String YGRDESC;
}
