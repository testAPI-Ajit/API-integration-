package in.kpmg.iocl.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "division_code_master")
@Data
public class DivisonCodesModel {
    @Id
    private Integer id;
    private String division_code;
}
