package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MaterialMasterEmvke {
    @JsonProperty("item")
    private List<MaterialMasterEmvkeItem> item;
}
