package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class YV_CONTRACT_RATES_I_BUKRS {
    @JsonProperty("item")
    private List<YV_CONTRACT_RATES_I_BUKRS_Item> item;
}
