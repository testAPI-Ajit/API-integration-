package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class YV_LU_PCK_Rate_Response {
   @JsonProperty("E_MSG")
   private String E_MSG;
   @JsonProperty("ET_TRANSRATE")
   private YV_LU_PCK_Rate_ET_TRANSRATE ET_TRANSRATE;
   @JsonProperty("ET_CAR_GRP")
   private YV_LU_PCK_Rate_ET_CAR_GRP ET_CAR_GRP;
}
