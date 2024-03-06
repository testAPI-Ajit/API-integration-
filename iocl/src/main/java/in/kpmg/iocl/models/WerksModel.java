package in.kpmg.iocl.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "werks_master")
public class WerksModel {
    @Id
    private Integer id;
    private String werks;
}
