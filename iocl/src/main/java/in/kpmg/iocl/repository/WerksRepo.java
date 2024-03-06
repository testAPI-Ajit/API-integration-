package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.WerksModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WerksRepo extends JpaRepository<WerksModel,Integer> {
}
