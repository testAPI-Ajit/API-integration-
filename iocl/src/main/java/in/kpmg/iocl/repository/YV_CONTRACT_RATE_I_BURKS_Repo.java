package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_CONTRACT_RATE_I_BURKS;
import org.springframework.boot.json.JsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YV_CONTRACT_RATE_I_BURKS_Repo extends JpaRepository<YV_CONTRACT_RATE_I_BURKS,Long> {
}
