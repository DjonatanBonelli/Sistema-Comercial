
package sistema.comercial.Controllers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sistema.comercial.Entities.Vendas;
import sistema.comercial.Repositories.VendasRepository;

@RestController
@AllArgsConstructor
public class SistemaComercialControllerVendas {
    VendasRepository repository;
    
    @GetMapping("/vendas")
    public List<Vendas> getAllVendas() {
        return repository.findAll();
    }
    
    @GetMapping("/vendas/{id}")
    public Vendas getVendasById(@PathVariable Long id) {
        return repository.findById(id).get();
    }
    
    @PostMapping("/vendas")
    public Vendas saveVendas(@RequestBody Vendas vendas) {
        return repository.save(vendas);
    }
    
    @DeleteMapping("/vendas/{id}")
    public void deleteVendas(@PathVariable Long id) {
        repository.deleteById(id);
    }
}