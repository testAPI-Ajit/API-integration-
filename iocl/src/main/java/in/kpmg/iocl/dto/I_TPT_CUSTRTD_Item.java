package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class I_TPT_CUSTRTD_Item {
    @JsonProperty("MANDT")
    private String MANDT;
    @JsonProperty("VSTEL")
    private String VSTEL;
    @JsonProperty("KUNWE")
    private String KUNWE;
    @JsonProperty("RTDSTATUS")
    private String RTDSTATUS;
    @JsonProperty("BEGDA")
    private String BEGDA;
    @JsonProperty("ENDDA")
    private String ENDDA;
    @JsonProperty("DIST_P")
    private String DIST_P;
    @JsonProperty("DIST_H")
    private String DIST_H;
    @JsonProperty("DIST_HH")
    private String DIST_HH;
    @JsonProperty("DESTCLUSTER")
    private String DESTCLUSTER;
    @JsonProperty("FDZ_IND")
    private String FDZ_IND;
    @JsonProperty("VEHCAP_IND")
    private String VEHCAP_IND;
    @JsonProperty("LEVI_ONEWAY")
    private String LEVI_ONEWAY;
    @JsonProperty("LEVI_TWOWAY")
    private String LEVI_TWOWAY;
    @JsonProperty("APPROVAL_REF")
    private String APPROVAL_REF;
    @JsonProperty("CHANGE_REF")
    private String CHANGE_REF;
    @JsonProperty("ERNAM")
    private String ERNAM;
    @JsonProperty("ERDAT")
    private String ERDAT;
    @JsonProperty("ERZET")
    private String ERZET;
    @JsonProperty("AENAM")
    private String AENAM;
    @JsonProperty("AEDAT")
    private String AEDAT;
    @JsonProperty("AEZET")
    private String AEZET;
    @JsonProperty("GEO_RTD")
    private String GEO_RTD;
    @JsonProperty("SHPT_STATE")
    private String SHPT_STATE;
    @JsonProperty("SHIP_STATE")
    private String SHIP_STATE;
    @JsonProperty("SHPT_BOTTOM_LOAD")
    private String SHPT_BOTTOM_LOAD;
}
