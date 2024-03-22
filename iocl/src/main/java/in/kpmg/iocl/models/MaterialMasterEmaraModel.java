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
    @Column(name = "division_code")
    private String division_code;
    @Column(name = "laeda")
    private String LAEDA;
    @Column(name = "bismt")
    private String BISMT;
    @Column(name = "mtart")
    private String MTART;
    @Column(name = "stor")
    private String STOR;
    @Column(name = "matkl")
    private String MATKL;
    @Column(name = "volum")
    private String VOLUM;
    @Column(name = "voleh")
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
