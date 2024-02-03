package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialMasterEmvkeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MaterialMasterEmvkeRepo extends JpaRepository<MaterialMasterEmvkeModel,Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from pricing_tool.yv_material_master_all_views_e_mvke where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "dwerk,kondm,kondmt,ktgrm,ktgrmt,matnr,mvgr1,mvgr2,mvgr3,vkorg,vtweg,division_code\torder by id desc)cnt from pricing_tool.yv_material_master_all_views_e_mvke) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
