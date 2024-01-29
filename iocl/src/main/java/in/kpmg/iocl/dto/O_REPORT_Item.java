package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class O_REPORT_Item {
    @JsonProperty("BUKRS")
         private String BUKRS;
    @JsonProperty("TPLST")
    private String TPLST;
    @JsonProperty("VSTEL")
    private String VSTEL;
    @JsonProperty("NAME1")
    private String NAME1;
    @JsonProperty("YYTENDERNO")
    private String YYTENDERNO;
    @JsonProperty("MATKL")
    private String MATKL;
    @JsonProperty("CAPCLUSTER")
    private String CAPCLUSTER;
    @JsonProperty("CAP_DESC")
    private String CAP_DESC;
    @JsonProperty("RTDCLUSTER")
    private String RTDCLUSTER;
    @JsonProperty("RTD_DESC")
    private String RTD_DESC;
    @JsonProperty("DESTCLUSTER")
    private String DESTCLUSTER;
    @JsonProperty("DEST_DESC")
    private String DEST_DESC;
    @JsonProperty("KUNWE")
    private String KUNWE;
    @JsonProperty("NAME2")
    private String NAME2;
    @JsonProperty("RATEAPP_DESC")
    private String RATEAPP_DESC;
    @JsonProperty("FINAL_UOM")
    private String FINAL_UOM;
    @JsonProperty("FINAL_UOMKM")
    private String FINAL_UOMKM;
    @JsonProperty("REMARKS")
    private String REMARKS;
}
