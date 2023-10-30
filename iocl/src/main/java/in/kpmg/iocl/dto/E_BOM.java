package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class E_BOM {
    @JsonProperty("item")
    private List<E_BOM_Item> item;
}
