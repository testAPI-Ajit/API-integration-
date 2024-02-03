package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialMasterEmarcModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MaterialMasterEmarcRepo extends JpaRepository<MaterialMasterEmarcModel,Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from pricing_tool.yv_material_master_all_views_e_marc where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "abfac,matnr,umrsl,uomgr,werks,division_code order by id desc)cnt from pricing_tool.yv_material_master_all_views_e_marc) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
