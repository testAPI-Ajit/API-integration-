package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MaterialMasterEmbewItem {
    @JsonProperty("MATNR")
    private String MATNR;
    @JsonProperty("BWKEY")
    private String BWKEY;
    @JsonProperty("BKLAS")
    private String BKLAS;
    @JsonProperty("VPRSV")
    private String VPRSV;
    @JsonProperty("VERPR")
    private String VERPR;
    @JsonProperty("STPRS")
    private String STPRS;}
