package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialMasterEmbewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MaterialMasterEmbewRepo extends JpaRepository<MaterialMasterEmbewModel,Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from pricing_tool.yv_material_master_all_views_e_mbew where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "bklas,bwkey,matnr,stprs,verpr,vprsv,division_code\torder by id desc)cnt from pricing_tool.yv_material_master_all_views_e_mbew) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
