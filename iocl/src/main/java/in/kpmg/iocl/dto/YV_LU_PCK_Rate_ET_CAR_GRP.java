package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class YV_LU_PCK_Rate_ET_CAR_GRP { @JsonProperty("item")
private List<ET_CAR_GRP> item;

}
