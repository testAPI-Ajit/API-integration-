package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.BurksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BurksRepo extends JpaRepository <BurksModel,Integer> {
}
