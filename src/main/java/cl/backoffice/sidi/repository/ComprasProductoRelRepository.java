package cl.backoffice.sidi.repository;

import cl.backoffice.sidi.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasProductoRelRepository extends JpaRepository<CompraModel,Long> {
}
