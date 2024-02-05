package in.kpmg.iocl.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "API_ERROR_LOG")
public class Api_Error_Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Integer service;
    private String input;
    private String error_msg;
}
