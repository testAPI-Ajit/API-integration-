package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MaterialMasterEmarm {
    @JsonProperty("item")
    private List<MaterialMasterEmarmItem> item;
}
