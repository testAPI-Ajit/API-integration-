package in.kpmg.iocl.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Y_LUBEBOM_DNLD_E_BOM")
public class Y_LUBEBOM_DNLD_Model {
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

    private String WERKS;
    private String MATNR;
    private String STLNR;
    private String STLAL;
    private String POSNR;
    private String STLKN;
    private String IDNRK;
    private String COMNM;
    private String MEINS;
    private String MENGE;
    private String VERPR;
    private String STPRS;
    private String MTART;
    private String DATUV;
}
