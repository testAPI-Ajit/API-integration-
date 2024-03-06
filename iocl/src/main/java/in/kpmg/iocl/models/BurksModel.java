package in.kpmg.iocl.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "burks_master")
@Data
public class BurksModel {
    @Id
    private Integer id;
    private String burks;
}
