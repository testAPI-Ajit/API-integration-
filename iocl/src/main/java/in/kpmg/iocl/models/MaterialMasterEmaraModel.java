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
    @Column(name = "matnr")
    private String MATNR;
    @Column(name = "maktx")
    private String MAKTX;
    @Column(name = "bism")
    private Integer BISM;
    @Column(name = "groes")
    private String GROES;
    @Column(name = "wrkst")
    private String WRKST;
    @Column(name = "ferth")
    private String FERTH;
    @Column(name = "normt")
    private String NORMT;
    @Column(name = "meins")
    private String MEINS;
    @Column(name = "brgew")
    private String BRGEW;
    @Column(name = "ntgew")
    private String NTGEW;
    @Column(name = "tragr")
    private String TRAGR;
    @Column(name = "ersda")
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
