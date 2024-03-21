package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MaterialMasterEmaraItem {
    @JsonProperty("MATNR")
    private String MATNR;
    @JsonProperty("MAKTX")
    private String MAKTX;
    @JsonProperty("BISM")
    private Integer BISM;
    @JsonProperty("GROES")
    private String GROES;
    @JsonProperty("WRKST")
    private String WRKST;
    @JsonProperty("FERTH")
    private String FERTH;
    @JsonProperty("NORMT")
    private String NORMT;
    @JsonProperty("MEINS")
    private String MEINS;
    @JsonProperty("BRGEW")
    private String BRGEW;
    @JsonProperty("NTGEW")
    private String NTGEW;
    @JsonProperty("TRAGR")
    private String TRAGR;
    @JsonProperty("ERSDA")
    private String ERSDA;
    @JsonProperty("LAEDA")
    private String LAEDA;

    @JsonProperty("BISMT")
    private String BISMT;
    @JsonProperty("MTART")
    private String MTART;
    @JsonProperty("STOR")
    private String STOR;
    @JsonProperty("MATKL")
    private String MATKL;
    @JsonProperty("VOLUM")
    private String VOLUM;
    @JsonProperty("VOLEH")
    private String VOLEH;
}
