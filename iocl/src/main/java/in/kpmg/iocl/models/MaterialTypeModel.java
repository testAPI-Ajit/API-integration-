package in.kpmg.iocl.models;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material_type_master")
@Data
public class MaterialTypeModel {
    @Id
    private Integer id;
    private String material_type;
}

