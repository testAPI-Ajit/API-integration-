package in.kpmg.iocl.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "API_ERROR_LOG")
public class Api_Error_Logs {
    @Id
    private Long id;
    private String date;
    private Integer service;
    private String input;
    private String error_msg;
}
