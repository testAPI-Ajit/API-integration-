package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_EXCHG_RATE_ET_EXCH_RATE_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YV_EXCHG_RATE_ET_EXCH_RATE_Repo extends JpaRepository<YV_EXCHG_RATE_ET_EXCH_RATE_Model,Long> {
}
