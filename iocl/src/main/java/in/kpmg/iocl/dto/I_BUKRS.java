package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class I_BUKRS {
    @JsonProperty("item")
    private List<I_BUKRS_Item> item;
}
