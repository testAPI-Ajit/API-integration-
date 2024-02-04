package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_LU_PCK_RATE_ET_CAR_GRP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface YV_LU_PCK_RATE_ET_CAR_GRP_Repo extends JpaRepository<YV_LU_PCK_RATE_ET_CAR_GRP,Long> {

    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.yv_lu_pck_rate_et_car_grp where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "begda,endda,mandt,werks,wgt_from,yycarton_grp,wgt_to,yyrate_percent order by mandt)cnt from pricing_tool.yv_lu_pck_rate_et_car_grp) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
