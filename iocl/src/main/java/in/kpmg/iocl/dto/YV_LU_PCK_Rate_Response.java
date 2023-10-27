package in.kpmg.iocl.dto;

import lombok.Data;

import java.util.List;

@Data
public class YV_LU_PCK_Rate_Response {
   private String E_MSG;
   private YV_LU_PCK_Rate_ET_TRANSRATE ET_TRANSRATE;
   private YV_LU_PCK_Rate_ET_CAR_GRP ET_CAR_GRP;
}
