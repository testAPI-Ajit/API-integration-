package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MaterialMasterResponse {
    @JsonProperty("E_MARC")
    private MaterialMasterEmarc E_MARC;
    @JsonProperty("E_MARA")
    private MaterialMasterEmara E_MARA;
    @JsonProperty("E_MARM")
    private MaterialMasterEmarm E_MARM;
    @JsonProperty("E_MBEW")
    private MaterialMasterEmbew E_MBEW;
    @JsonProperty("E_MVKE")
    private MaterialMasterEmvke E_MVKE;

    @JsonProperty("E_GRADEMAST_LG")
    private E_GRADEMAST_LG E_GRADEMAST_LG;
    @JsonProperty("E_MSG")
    private String E_MSG;
}
