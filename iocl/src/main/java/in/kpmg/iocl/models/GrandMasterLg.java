package in.kpmg.iocl.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "grand_mast_lg")
@Data
public class GrandMasterLg {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String mandt;
        private String ygradecd;
        private String ygrdesc;
        private String division_code;
}
