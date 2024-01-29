package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MaterialMasterEmarcItem {

    @JsonProperty("MATNR")
    private String MATNR;
    @JsonProperty("WERKS")
    private String WERKS;
    @JsonProperty("UOMGR")
    private String UOMGR;
    @JsonProperty("UMRSL")
    private String UMRSL;
    @JsonProperty("ABFAC")
    private String ABFAC;
}
