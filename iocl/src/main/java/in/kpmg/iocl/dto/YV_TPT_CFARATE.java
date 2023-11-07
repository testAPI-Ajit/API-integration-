package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class YV_TPT_CFARATE {
    @JsonProperty("item")
    private List<ET_CFARATES> item;
}
