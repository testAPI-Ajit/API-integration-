package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialMasterEmbewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialMasterEmbewRepo extends JpaRepository<MaterialMasterEmbewModel,Long> {
}
