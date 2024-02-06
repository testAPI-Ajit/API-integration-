package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.API_type_config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface API_type_config_repo extends JpaRepository<API_type_config,Integer> {
}
