package in.kpmg.iocl.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "YM_PO_DET_RFC_HO_LUBES")
public class YM_PO_DET_RFC_HO_LUBES_Model {
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

    private String BSART;
    private String BSTYP;
    private String EBELN;
    private String EBELP;
    private String LOEKZ;
    private String WERKS;
    private String AEDAT;
    private String WAERS;
    private String KONNR;
    private String KTPNR;
    private String MTART;
    private String MATKL;
    private String MATNR;
    private String BELNR;
    private String GJAHR;
    private String BUZEI;
    private String MENGE;
    private String MEINS;
    private String BSTME;
    @Column(name = "wrbtr")
    private String WRBTR;
    @Column(name = "wemng")
    private String WEMNG;
    @Column(name = "kschl")
    private String KSCHL;

}
