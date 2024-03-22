package in.kpmg.iocl.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(name = "LAEDA")
    private String LAEDA;
    @Column(name = "BISMT")
    private String BISMT;
    @Column(name = "MTART")
    private String MTART;
    @Column(name = "STOR")
    private String STOR;
    @Column(name = "MATKL")
    private String MATKL;
    @Column(name = "VOLUM")
    private String VOLUM;
    @Column(name = "VOLEH")
    private String VOLEH;


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
