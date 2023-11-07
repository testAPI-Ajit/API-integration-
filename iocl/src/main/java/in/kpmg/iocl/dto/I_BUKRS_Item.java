package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class I_BUKRS_Item {
    @JsonProperty("MANDT")
      private String MANDT;
    @JsonProperty("BUKRS")
              private String BUKRS;
}
