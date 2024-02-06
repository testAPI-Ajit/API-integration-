package in.kpmg.iocl.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="API_TYPE_CONFIG")
@Data
public class API_type_config {
    
    @Id
    private Integer service;
    @Column(name = "from_date")
    private String fromDate;
    @Column(name = "to_date")
    private String toDate;
}
