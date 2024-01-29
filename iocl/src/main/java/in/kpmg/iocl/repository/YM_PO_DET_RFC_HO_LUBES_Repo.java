package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YM_PO_DET_RFC_HO_LUBES_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YM_PO_DET_RFC_HO_LUBES_Repo extends JpaRepository<YM_PO_DET_RFC_HO_LUBES_Model,Long> {
}
