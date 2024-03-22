package in.kpmg.iocl.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "YV_MATERIAL_MASTER_ALL_VIEWS_E_MARM")
public class MaterialMasterEmarmModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean isActive = true;
    @CreationTimestamp
    @Column(name="createddate")
    public LocalDateTime createdOn;
    @UpdateTimestamp
    @Column(name="modifieddate")
    public LocalDateTime  modifiedDate;

    private String division_code;
    private String MANTR;
    private String MATNR;
    private String UMREN;
    private String MEINH;
    private String SEPRTR;
    private String UMREZ;
    private String MEINS;

}
