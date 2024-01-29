package in.kpmg.iocl.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="YV_ET_CFARATES")

public class YV_TPT_CFARATES_Model {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String MANDT;
   private String VSTEL;
   private String YYTENDERNO;
   private String OUTSIDESTATE;
   private String SLAB_FROM_KM;
   private String SLAB_TO_KM;
   private String RATEUOM;
   private String REMARKS;
   private String ERNAM;
   private String ERZET;
   private String AENAM;
   private String AEZET;

   @CreationTimestamp
   @Column(name="ERDAT")
   public LocalDateTime ERDAT;
   @UpdateTimestamp
   @Column(name="AEDAT")
   public LocalDateTime  AEDAT;


}
