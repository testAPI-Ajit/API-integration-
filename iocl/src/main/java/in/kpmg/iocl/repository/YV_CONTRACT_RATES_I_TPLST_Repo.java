package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_CONTRACT_RATES_I_TPLST;
import org.springframework.boot.json.JsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface YV_CONTRACT_RATES_I_TPLST_Repo extends JpaRepository<YV_CONTRACT_RATES_I_TPLST,Long> {

    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.i_tpt_custrtd_i_bukrs where ctid in (\n" +
            "select ctid from (SELECT ctid, ROW_NUMBER() OVER (PARTITION BY\n" +
            "bukrs,mandt,tplst_high,tplst_low,tplst_option,tplst_sign,high,low,option,sign order by mandt) cnt\n" +
            "\t\t\t\t  FROM pricing_tool.i_tpt_custrtd_i_bukrs ) table1 where cnt>1)",nativeQuery = true)
    void delete();

}
