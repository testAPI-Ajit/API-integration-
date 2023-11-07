package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class YM_PO_DET_RFC_HO_LUBES_Response {
    @JsonProperty("OUTPUT")
    private YM_PO_DET_RFC_HO_LUBES_Output OUTPUT;

}
