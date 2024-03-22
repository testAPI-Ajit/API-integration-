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
    private String MATNR;
    private String VKORG;
    private String VTWEG;
    private String KONDM;
    private String KONDMT;
    private String KTGRM;
    private String KTGRMT;
    private String MVGR1;
    private String MVGR2;
    private String MVGR3;
    private String DWERK;
}
