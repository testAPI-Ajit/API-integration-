package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_TPT_CFACONT_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YV_ET_CFACONT_Repo extends JpaRepository<YV_TPT_CFACONT_Model,Long> {
}
