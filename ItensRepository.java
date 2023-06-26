
package sistema.comercial.Repositories;

import sistema.comercial.Entities.Itens;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItensRepository extends JpaRepository<Itens, Long> {
    
}
