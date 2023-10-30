package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_CONTRACT_RATES_O_REPORT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YV_CONTRACT_RATES_O_REPORT_Repo extends JpaRepository<YV_CONTRACT_RATES_O_REPORT,Long> {
}
