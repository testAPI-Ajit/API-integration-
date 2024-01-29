package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EtExchRate {
    @JsonProperty("item")
    private List<EtExchRateItems> item;
}
