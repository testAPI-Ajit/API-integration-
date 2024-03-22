package in.kpmg.iocl.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "YV_MATERIAL_MASTER_ALL_VIEWS_E_MVKE")
public class MaterialMasterEmvkeModel {
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

    @Column(name = "division_code")
    private String division_code;
    @Column(name = "matnr")
    private String MATNR;
    @Column(name = "vkorg")
    private String VKORG;
    @Column(name = "vtweg")
    private String VTWEG;
    @Column(name = "kondm")
    private String KONDM;
    @Column(name = "kondmt")
    private String KONDMT;
    @Column(name = "ktgrm")
    private String KTGRM;
    @Column(name = "ktgrmt")
    private String KTGRMT;
    @Column(name = "mvgr1")
    private String MVGR1;
    @Column(name = "mvgr2")
    private String MVGR2;
    @Column(name = "mvgr3")
    private String MVGR3;
    @Column(name = "dwerk")
    private String DWERK;
}
