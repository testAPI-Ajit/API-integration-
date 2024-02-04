package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.I_TPT_CUSTRTD_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface I_TPT_CUSTRTD_Repo extends JpaRepository<I_TPT_CUSTRTD_Model,Long> {
    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.i_tpt_custrtd where ctid in (\n" +
            "select ctid from (SELECT ctid, ROW_NUMBER() OVER (PARTITION BY\n" +
            " aedat , aenam, aezet , approval_ref ,begda,change_ref,\n" +
            "  destcluster,dist_h,dist_hh,dist_p,endda,erdat,ernam,erzet,fdz_ind,\n" +
            "\tgeo_rtd,kunwe,levi_oneway,levi_twoway,mandt,rtdstatus,ship_state,\n" +
            "\tshpt_bottom_load,shpt_state,vehcap_ind,vstel\n" +
            "  ORDER BY mandt) cnt\n" +
            "FROM pricing_tool.i_tpt_custrtd ) table1 where cnt>1)",nativeQuery = true)
    void delete();
}
