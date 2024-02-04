package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_TPT_CFACONT_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface YV_ET_CFACONT_Repo extends JpaRepository<YV_TPT_CFACONT_Model,Long> {
    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.yv_et_cfacont where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "aedat,aenam,aezet,end_date,erdat,ernam,erzet,extn_dt1,extn_dt2,extn_dt3\n" +
            ",extn_ref1,extn_ref2,extn_ref3,fixed_charges,handling_rate,hsd_basedate,\n" +
            "hsd_baserate,mandt,remarks,start_date, trans_uom,vstel,yytenderno,yyvendor order by id desc)cnt from pricing_tool.yv_et_cfacont) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
