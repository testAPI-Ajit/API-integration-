package in.kpmg.iocl.repository;

import in.kpmg.iocl.models.I_TPT_CUSTRTD_I_WERKS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_TPT_CUSTRTD_I_WERKS_Repo extends JpaRepository<I_TPT_CUSTRTD_I_WERKS,Long> {
}
