package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MaterialMasterEmarmItem {
    @JsonProperty("MATNR")
    private String MATNR;
    @JsonProperty("UMREN")
    private String UMREN;
    @JsonProperty("MEINH")
    private String MEINH;
    @JsonProperty("SEPRTR")
    private String SEPRTR;
    @JsonProperty("UMREZ")
    private String UMREZ;
    @JsonProperty("MEINS")
    private String MEINS;

}
