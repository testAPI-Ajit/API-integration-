package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.DivisonCodesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DivisonCodesRepo extends JpaRepository<DivisonCodesModel,Integer> {
}
