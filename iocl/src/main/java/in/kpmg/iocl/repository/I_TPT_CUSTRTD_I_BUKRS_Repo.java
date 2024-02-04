package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.I_TPT_CUSTRTD_I_BUKRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface I_TPT_CUSTRTD_I_BUKRS_Repo extends JpaRepository<I_TPT_CUSTRTD_I_BUKRS,Long> {
    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.i_tpt_custrtd_i_bukrs where ctid in (\n" +
            "select ctid from (SELECT ctid, ROW_NUMBER() OVER (PARTITION BY\n" +
            "bukrs,mandt,tplst_high,tplst_low,tplst_option,tplst_sign,high,low,option,sign order by mandt) cnt\n" +
            "\t\t\t\t  FROM pricing_tool.i_tpt_custrtd_i_bukrs ) table1 where cnt>1)",nativeQuery = true)
    void delete();
}
