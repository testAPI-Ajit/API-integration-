package in.kpmg.iocl.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="YV_ET_CFACONT")

public class YV_TPT_CFACONT_Model {

    private String MANDT;
    private String VSTEL;
    private String YYTENDERNO;
    private String REMARKS;
    private String TRANS_UOM;
    private String YYVENDOR;
    private String FIXED_CHARGES;
    private String HANDLING_RATE;
    private String HSD_BASERATE;
    private String EXTN_REF1;
    private String EXTN_REF2;
    private String EXTN_REF3;
    private String ERNAM;
    private String ERZET;
    private String AENAM;
    private String AEZET;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    @Column(name="START_DATE")
    public LocalDateTime START_DATE;
    @CreationTimestamp
    @Column(name="END_DATE")
    public LocalDateTime END_DATE;
    @CreationTimestamp
    @Column(name="HSD_BASEDATE")
    public LocalDateTime HSD_BASEDATE;
    @CreationTimestamp
    @Column(name="EXTN_DT1")
    public LocalDateTime EXTN_DT1;
    @CreationTimestamp
    @Column(name="EXTN_DT2")
    public LocalDateTime EXTN_DT2;
    @CreationTimestamp
    @Column(name="EXTN_DT3")
    public LocalDateTime EXTN_DT3;
    @CreationTimestamp
    @Column(name="ERDAT")
    public LocalDateTime ERDAT;
    @CreationTimestamp
    @Column(name="AEDAT")
    public LocalDateTime AEDAT;
}
