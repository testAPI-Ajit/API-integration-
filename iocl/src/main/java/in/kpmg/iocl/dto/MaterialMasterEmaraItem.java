package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MaterialMasterEmaraItem {
    @JsonProperty("MATNR")
    private String MATNR;
    @JsonProperty("MAKTX")
    private String MAKTX;//: "STOCK 6020 - IMPORTED",
    @JsonProperty("BISM")
    private Integer BISM;//
    @JsonProperty("GROES")
    private String GROES;//": "",
    @JsonProperty("WRKST")
    private Integer WRKST;
    @JsonProperty("FERTH")
    private String FERTH;//": "",
    @JsonProperty("NORMT")
    private String NORMT;//": "",
    @JsonProperty("MEINS")
    private String MEINS;//": "L29",
    @JsonProperty("BRGEW")
    private String BRGEW;//": "1.000",
    @JsonProperty("NTGEW")
    private String NTGEW;//": "1.000",
    @JsonProperty("TRAGR")
    private String TRAGR;//": "0001",
    @JsonProperty("ERSDA")
    private String ERSDA;//": "2001-08-03",
    @JsonProperty("LAEDA")
    private String LAEDA;//": "2022-01-05"
}
