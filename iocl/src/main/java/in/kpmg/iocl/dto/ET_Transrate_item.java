package in.kpmg.iocl.dto;

import lombok.Data;

@Data
public class ET_Transrate_item {
    private Integer MANDT;
    private Integer WERKS;
    private String VEH_TYPE;
    private String TU_NUMBER;
    private String BZIRK;
    private String KUNNR;
    private Integer YYRATE_APPLIC;
    private String BEGDA;
    private String ENDDA;
    private Integer YYBASE_RATE;
    private String PROVISIONAL;
    private String REMARKS;
}
