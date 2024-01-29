package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class YV_LU_PCK_Rate_ET_TRANSRATE {
    @JsonProperty("item")
    private List<ET_Transrate_item> item;
}

