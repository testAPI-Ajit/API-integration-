package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MaterialMasterEmara {
    @JsonProperty("item")
    private List<MaterialMasterEmaraItem> item;
}
