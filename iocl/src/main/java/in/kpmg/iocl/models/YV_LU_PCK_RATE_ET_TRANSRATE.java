package in.kpmg.iocl.models;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "YV_LU_PCK_RATE_ET_TRANSRATE")
@Data
public class YV_LU_PCK_RATE_ET_TRANSRATE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer MANDT;
    private Integer WERKS;
    private String VEH_TYPE;
    private String TU_NUMBER;
    private String BZIRK;
    private String KUNNR;
    private Integer YYRATE_APPLIC;
    private String BEGDA;
    private String ENDDA;
    private String YYBASE_RATE;
    private String PROVISIONAL;
    private String REMARKS;
    private Boolean isActive = true;
    @CreationTimestamp
    @Column(name="createddate")
    public LocalDateTime createdOn;
    @UpdateTimestamp
    @Column(name="modifieddate")
    public LocalDateTime  modifiedDate;
}
