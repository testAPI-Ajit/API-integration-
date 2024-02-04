package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YV_TPT_CFARATES_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface YV_ET_CFARATES_Repo extends JpaRepository<YV_TPT_CFARATES_Model,Long> {
    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.yv_et_cfarates where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "aedat,aenam,aezet,erdat,ernam,erzet,mandt,outsidestate,rateuom,remarks,slab_from_km,\n" +
            "\tslab_to_km,vstel,yytenderno\torder by id desc)cnt from pricing_tool.yv_et_cfarates) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();

}
