package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class YV_EXCHG_RATE_Resp {
    @JsonProperty("ET_EXCH_RATE")
    private EtExchRate ET_EXCH_RATE;
    @JsonProperty("E_MSG")
    private String E_MSG;
}
