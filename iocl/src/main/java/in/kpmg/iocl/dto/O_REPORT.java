package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class O_REPORT {
    @JsonProperty("item")
    private List<O_REPORT_Item> item;
}
