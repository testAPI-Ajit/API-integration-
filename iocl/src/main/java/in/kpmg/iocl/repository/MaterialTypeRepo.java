package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialTypeRepo extends JpaRepository<MaterialTypeModel,Integer> {
}
