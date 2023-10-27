package in.kpmg.iocl.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "YV_LU_PCK_RATE_ET_CAR_GRP")
public class YV_LU_PCK_RATE_ET_CAR_GRP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer MANDT;
    private Integer WERKS;
    private String YYCARTON_GRP;
    private String BEGDA;
    private String ENDDA;
    private String WGT_FROM;
    private String WGT_TO;
    private String YYRATE_PERCENT;
    private Boolean isActive = true;
    @CreationTimestamp
    @Column(name="createddate")
    public LocalDateTime createdOn;
    @UpdateTimestamp
    @Column(name="modifieddate")
    public LocalDateTime  modifiedDate;
}
