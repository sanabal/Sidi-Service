package cl.backoffice.sidi.repository;

import cl.backoffice.sidi.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel,Long> {
}
