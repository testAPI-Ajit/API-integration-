package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.MaterialMasterEmaraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Repository
public interface MaterialMasterEmaraRepo extends JpaRepository<MaterialMasterEmaraModel,Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "delete from pricing_tool.yv_material_master_all_views_e_mara where ctid in (\n" +
//            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
//            "bism,brgew,ersda,ferth,groes,laeda,maktx,matnr,meins,normt,ntgew,tragr,division_code,wrkst order by id desc)cnt from pricing_tool.yv_material_master_all_views_e_mara) table1\n" +
//            "where cnt>1)",nativeQuery = true)
//  void delete();

}
