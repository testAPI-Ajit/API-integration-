package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.Y_LUBEBOM_DNLD_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Y_LUBEBOM_DNLD_Repo extends JpaRepository<Y_LUBEBOM_DNLD_Model,Long> {
}
