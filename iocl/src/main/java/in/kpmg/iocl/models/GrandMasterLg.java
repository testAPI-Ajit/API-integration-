package in.kpmg.iocl.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "grand_mast_lg")
@Data
public class GrandMasterLg {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;
        @Column(name = "mandt")
        private String mandt;
        @Column(name = "ygradecd")
        private String ygradecd;
        @Column(name = "ygrdesc")
        private String ygrdesc;
        @Column(name = "division_code")
        private String division_code;
}
