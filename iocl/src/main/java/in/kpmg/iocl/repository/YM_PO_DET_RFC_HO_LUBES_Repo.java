package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.YM_PO_DET_RFC_HO_LUBES_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface YM_PO_DET_RFC_HO_LUBES_Repo extends JpaRepository<YM_PO_DET_RFC_HO_LUBES_Model,Long> {
    @Transactional
    @Modifying
    @Query(value ="delete from pricing_tool.ym_po_det_rfc_ho_lubes where ctid in (\n" +
            "select ctid from (select ctid,ROW_NUMBER() OVER (PARTITION BY\n" +
            "aedat,belnr,bsart,bstme,bstyp,buzei,ebeln,ebelp,gjahr,konnr,ktpnr,loekz,matkl,\n" +
            "matnr,meins,menge,mtart,waers,werks, wrbtr order by werks)cnt from pricing_tool.ym_po_det_rfc_ho_lubes) table1\n" +
            "where cnt>1)",nativeQuery = true)
    void delete();
}
