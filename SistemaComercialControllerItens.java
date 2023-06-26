
package sistema.comercial.Controllers;

import sistema.comercial.Entities.Itens;
import sistema.comercial.Repositories.ItensRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SistemaComercialControllerItens {
    ItensRepository repository;
    
    @GetMapping("/gerenciamento")
    public List<Itens>getAllItens() {
        return repository.findAll();
    }
    
    @GetMapping("/gerenciamento/{id}")
    public Itens getItensById(@PathVariable Long id) {
        return repository.findById(id).get();
    }
    
    @PostMapping("/gerenciamento")
    public Itens saveItens(@RequestBody Itens item) {
        return repository.save(item);
    }
    
    @DeleteMapping("/gerenciamento/{id}")
    public void deleteItens(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
