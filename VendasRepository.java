package sistema.comercial.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sistema.comercial.Entities.ItensVendidos;
import sistema.comercial.Entities.Vendas;

public interface VendasRepository extends JpaRepository<Vendas, Long>{

}
