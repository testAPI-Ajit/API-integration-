package in.kpmg.iocl.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "YV_MATERIAL_MASTER_ALL_VIEWS_E_MARA")
public class MaterialMasterEmaraModel {
    private String MATNR;
    private String MAKTX;
    private Integer BISM;
    private String GROES;
    private String WRKST;
    private String FERTH;
    private String NORMT;
    private String MEINS;
    private String BRGEW;
    private String NTGEW;
    private String TRAGR;
    private String ERSDA;
    private String division_code;
    private String LAEDA;

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
}
