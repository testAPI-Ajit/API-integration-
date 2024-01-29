package in.kpmg.iocl.dto;

import lombok.Data;
import org.json.JSONPropertyIgnore;

import java.util.List;

@Data
public class ExchangeRateResponse {
    private String E_MSG;
    List<ExchangeRateItemMaster> item;
}
