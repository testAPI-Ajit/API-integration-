package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialMasterEmarmModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialMasterEmarmRepo extends JpaRepository <MaterialMasterEmarmModel,Long> {
}
