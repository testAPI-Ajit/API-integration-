package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class E_GRADEMAST_LG {

    @JsonProperty("item")
    private List<E_GRADEMAST_LG_Item> item;
}
