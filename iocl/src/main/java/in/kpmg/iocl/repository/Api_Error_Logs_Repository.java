package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.Api_Error_Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Api_Error_Logs_Repository extends JpaRepository<Api_Error_Logs,Long> {
}
