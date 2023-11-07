package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialMasterEmarcModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialMasterEmarcRepo extends JpaRepository<MaterialMasterEmarcModel,Long> {
}
