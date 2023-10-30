package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import in.kpmg.iocl.dto.E_BOM;
import lombok.Data;

@Data
public class Y_LUBEBOM_DNLD_Resp {
    @JsonProperty("E_BOM")
    private E_BOM E_BOM;
}
