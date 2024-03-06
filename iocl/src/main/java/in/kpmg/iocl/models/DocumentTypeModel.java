package in.kpmg.iocl.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document_type_master")
@Data
public class DocumentTypeModel {
    @Id
    private Integer id;
    private String document_type;
}
