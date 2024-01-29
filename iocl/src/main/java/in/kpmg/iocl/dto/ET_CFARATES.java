package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ET_CFARATES {
    @JsonProperty("MANDT")
    private String MANDT;
    @JsonProperty("VSTEL")
    private String VSTEL;
    @JsonProperty("YYTENDERNO")
    private String YYTENDERNO;
    @JsonProperty("OUTSIDESTATE")
    private String OUTSIDESTATE;
    @JsonProperty("SLAB_FROM_KM")
    private String SLAB_FROM_KM;
    @JsonProperty("SLAB_TO_KM")
    private String SLAB_TO_KM;
    @JsonProperty("RATEUOM")
    private String RATEUOM;
    @JsonProperty("REMARKS")
    private String REMARKS;
    @JsonProperty("ERNAM")
    private String ERNAM;
    @JsonProperty("ERZET")
    private String ERZET;
    @JsonProperty("AENAM")
    private String AENAM;
    @JsonProperty("AEZET")
    private String AEZET;
}
