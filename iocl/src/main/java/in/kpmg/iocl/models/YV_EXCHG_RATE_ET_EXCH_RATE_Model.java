package in.kpmg.iocl.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "YV_EXCHG_RATE_ET_EXCH_RATE")
public class YV_EXCHG_RATE_ET_EXCH_RATE_Model {
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
    private String KURST;
    private String FCURR;
    private String TCURR;
    private String GDATU;
    private String UKURS;
    private String FFACT;
    private String TFACT;
}
