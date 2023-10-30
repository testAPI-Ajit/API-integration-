package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MaterialMasterEmbew {
    @JsonProperty("item")
    private List<MaterialMasterEmbewItem> item;
}
