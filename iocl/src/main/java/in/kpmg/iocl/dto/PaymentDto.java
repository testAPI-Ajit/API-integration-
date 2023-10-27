package in.kpmg.iocl.dto;

import lombok.Data;


@Data
public class PaymentDto {

    private Integer service;

    private String I_FROM_DATE;

    private String I_TO_DATE;

    private String WERKS;
}
