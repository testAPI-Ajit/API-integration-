package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ET_CFACONT {
    @JsonProperty("MANDT")
    private String MANDT;
    @JsonProperty("VSTEL")
    private String VSTEL;
    @JsonProperty("YYTENDERNO")
    private String YYTENDERNO;
    @JsonProperty("REMARKS")
    private String REMARKS;
    @JsonProperty("TRANS_UOM")
    private String TRANS_UOM;
    @JsonProperty("YYVENDOR")
    private String YYVENDOR;
    @JsonProperty("FIXED_CHARGES")
    private String FIXED_CHARGES;
    @JsonProperty("HANDLING_RATE")
    private String HANDLING_RATE;
    @JsonProperty("HSD_BASERATE")
    private String HSD_BASERATE;
    @JsonProperty("EXTN_REF1")
    private String EXTN_REF1;
    @JsonProperty("EXTN_REF2")
    private String EXTN_REF2;
    @JsonProperty("EXTN_REF3")
    private String EXTN_REF3;
    @JsonProperty("ERNAM")
    private String ERNAM;
    @JsonProperty("AENAM")
    private String AENAM;
    @JsonProperty("ERZET")
    private String ERZET;
    @JsonProperty("AEZET")
    private String AEZET;
}
