package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class E_BOM_Item {
    @JsonProperty("WERKS")
    private String WERKS;
    @JsonProperty("MATNR")
    private String MATNR;
    @JsonProperty("STLNR")
    private String STLNR;
    @JsonProperty("STLAL")
    private String STLAL;
    @JsonProperty("POSNR")
    private String POSNR;
    @JsonProperty("STLKN")
    private String STLKN;
    @JsonProperty("IDNRK")
    private String IDNRK;
    @JsonProperty("COMNM")
    private String COMNM;
    @JsonProperty("MEINS")
    private String MEINS;
    @JsonProperty("MENGE")
    private String MENGE;
    @JsonProperty("VERPR")
    private String VERPR;
    @JsonProperty("STPRS")
    private String STPRS;
    @JsonProperty("MTART")
    private String MTART;
    @JsonProperty("DATUV")
    private String DATUV;
}
