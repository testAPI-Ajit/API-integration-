package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialMasterEmaraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface MaterialMasterEmaraRepo extends JpaRepository<MaterialMasterEmaraModel,Long> {

}
