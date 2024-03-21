package in.kpmg.iocl.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandMasterLgRepo extends JpaRepository<GrandMasterLg,Long> {
}
