package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class YM_PO_DET_RFC_HO_LUBES_Item {

    @JsonProperty("BSART")
    private String BSART;
    @JsonProperty("BSTYP")
    private String BSTYP;
    @JsonProperty("EBELN")
    private String EBELN;
    @JsonProperty("EBELP")
    private String EBELP;
    @JsonProperty("LOEKZ")
    private String LOEKZ;
    @JsonProperty("WERKS")
    private String WERKS;
    @JsonProperty("AEDAT")
    private String AEDAT;
    @JsonProperty("WAERS")
    private String WAERS;
    @JsonProperty("KONNR")
    private String KONNR;
    @JsonProperty("KTPNR")
    private String KTPNR;
    @JsonProperty("MTART")
    private String MTART;
    @JsonProperty("MATKL")
    private String MATKL;
    @JsonProperty("MATNR")
    private String MATNR;
    @JsonProperty("BELNR")
    private String BELNR;
    @JsonProperty("GJAHR")
    private String GJAHR;
    @JsonProperty("BUZEI")
    private String BUZEI;
    @JsonProperty("MENGE")
    private String MENGE;
    @JsonProperty("MEINS")
    private String MEINS;
    @JsonProperty("BSTME")
    private String BSTME;
}
