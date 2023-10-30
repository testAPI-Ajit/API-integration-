package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class I_TPLST {
    @JsonProperty("item")
    private I_TPLST_Item item;

}
