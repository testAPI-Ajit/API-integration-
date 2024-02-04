package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.I_TPT_CUSTRTD_I_WERKS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface I_TPT_CUSTRTD_I_WERKS_Repo extends JpaRepository<I_TPT_CUSTRTD_I_WERKS,Long> {
    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.i_tpt_custrtd_i_werks where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "mandt,werks order by mandt)cnt from pricing_tool.i_tpt_custrtd_i_werks) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
