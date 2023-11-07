package in.kpmg.iocl.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "YV_CONTRACT_RATES_O_REPORT")
public class YV_CONTRACT_RATES_O_REPORT {
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


    private String BUKRS;
    private String TPLST;
    private String VSTEL;
    private String NAME1;
    private String YYTENDERNO;
    private String MATKL;
    private String CAPCLUSTER;
    private String CAP_DESC;
    private String RTDCLUSTER;
    private String RTD_DESC;
    private String DESTCLUSTER;
    private String DEST_DESC;
    private String KUNWE;
    private String NAME2;
    private String RATEAPP_DESC;
    private String FINAL_UOM;
    private String FINAL_UOMKM;
    private String REMARKS;
}
