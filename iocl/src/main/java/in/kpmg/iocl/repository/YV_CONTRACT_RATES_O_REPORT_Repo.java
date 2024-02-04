package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_CONTRACT_RATES_O_REPORT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface YV_CONTRACT_RATES_O_REPORT_Repo extends JpaRepository<YV_CONTRACT_RATES_O_REPORT,Long> {
    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.yv_contract_rates_o_report where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "bukrs,capcluster,cap_desc,destcluster,dest_desc,final_uom,final_uomkm,\n" +
            "\tkunwe,matkl,name1,name2,rateapp_desc,remarks,rtdcluster,rtd_desc\n" +
            ",tplst ,vstel,yytenderno  order by id desc)cnt from pricing_tool.yv_contract_rates_o_report) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
