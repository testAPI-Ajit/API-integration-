package in.kpmg.iocl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MaterialMasterEmvkeItem {
    @JsonProperty("MATNR")
    private String MATNR;
    @JsonProperty("VKORG")
    private String  VKORG;
    @JsonProperty("VTWEG")
    private String  VTWEG;
    @JsonProperty("KONDM")
    private String  KONDM;
    @JsonProperty("KONDMT")
    private String  KONDMT;
    @JsonProperty("KTGRM")
    private String KTGRM;
    @JsonProperty("KTGRMT")
    private String KTGRMT;
    @JsonProperty("MVGR1")
    private String MVGR1;
    @JsonProperty("MVGR2")
    private String MVGR2;
    @JsonProperty("MVGR3")
    private String MVGR3;
    @JsonProperty("DWERK")
    private String DWERK;
}
