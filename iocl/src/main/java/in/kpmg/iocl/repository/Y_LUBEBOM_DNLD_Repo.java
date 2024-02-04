package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.Y_LUBEBOM_DNLD_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Y_LUBEBOM_DNLD_Repo extends JpaRepository<Y_LUBEBOM_DNLD_Model,Long> {
    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.y_lubebom_dnld_e_bom where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            " comnm,datuv, idnrk,matnr,meins,menge,mtart,posnr,stlal,stlkn,stlnr,stprs,verpr\n" +
            ",werks\t\t order by werks)cnt from pricing_tool.y_lubebom_dnld_e_bom) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
