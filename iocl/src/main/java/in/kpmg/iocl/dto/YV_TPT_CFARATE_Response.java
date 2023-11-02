package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class YV_TPT_CFARATE_Response {
  @JsonProperty("ET_CFACONT")
    private YV_TPT_CFACONT YV_TPT_CFACONT;
    @JsonProperty("ET_CFARATES")
    private YV_TPT_CFARATE YV_TPT_CFARATES;

}
