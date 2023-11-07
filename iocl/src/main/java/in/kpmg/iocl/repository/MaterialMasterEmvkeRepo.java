package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialMasterEmvkeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialMasterEmvkeRepo extends JpaRepository<MaterialMasterEmvkeModel,Long> {
}
