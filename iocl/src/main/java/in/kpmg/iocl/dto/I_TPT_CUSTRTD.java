package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class I_TPT_CUSTRTD {
    @JsonProperty("item")
   private List<I_TPT_CUSTRTD_Item> item;
}
