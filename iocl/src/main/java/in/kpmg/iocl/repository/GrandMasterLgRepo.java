package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.GrandMasterLg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandMasterLgRepo extends JpaRepository<GrandMasterLg,Long> {
}