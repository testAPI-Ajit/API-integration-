package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.DocumentTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DocumentTypeRepo extends JpaRepository<DocumentTypeModel,Integer> {
}
