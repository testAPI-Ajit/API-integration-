package in.kpmg.iocl.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "I_TPT_CUSTRTD")
public class I_TPT_CUSTRTD_Model {
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



    private String MANDT;
    private String VSTEL;
    private String KUNWE;
    private String RTDSTATUS;
    private String BEGDA;
    private String ENDDA;
    private String DIST_P;
    private String DIST_H;
    private String DIST_HH;
    private String DESTCLUSTER;
    private String FDZ_IND;
    private String VEHCAP_IND;
    private String LEVI_ONEWAY;
    private String LEVI_TWOWAY;
    private String APPROVAL_REF;
    private String CHANGE_REF;
    private String ERNAM;
    private String ERDAT;
    private String ERZET;
    private String AENAM;
    private String AEDAT;
    private String AEZET;
    private String GEO_RTD;
    private String SHPT_STATE;
    private String SHIP_STATE;
    private String SHPT_BOTTOM_LOAD;
}
