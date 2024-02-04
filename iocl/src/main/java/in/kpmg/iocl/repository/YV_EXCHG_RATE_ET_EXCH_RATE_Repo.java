package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_EXCHG_RATE_ET_EXCH_RATE_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface YV_EXCHG_RATE_ET_EXCH_RATE_Repo extends JpaRepository<YV_EXCHG_RATE_ET_EXCH_RATE_Model,Long> {
    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.yv_exchg_rate_et_exch_rate where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "fcurr,ffact,gdatu,kurst,mandt,tcurr,tfact,ukurs order by mandt)cnt from pricing_tool.yv_exchg_rate_et_exch_rate ) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
