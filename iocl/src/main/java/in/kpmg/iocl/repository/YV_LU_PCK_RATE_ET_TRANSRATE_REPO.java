package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_LU_PCK_RATE_ET_TRANSRATE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface YV_LU_PCK_RATE_ET_TRANSRATE_REPO extends JpaRepository<YV_LU_PCK_RATE_ET_TRANSRATE,Long> {

    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.yv_lu_pck_rate_et_transrate where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "begda,bzirk,endda,kunnr,mandt,provisional,remarks,tu_number,veh_type,\n" +
            "werks,yybase_rate,yyrate_applic   order by mandt)cnt from pricing_tool.yv_lu_pck_rate_et_transrate) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
