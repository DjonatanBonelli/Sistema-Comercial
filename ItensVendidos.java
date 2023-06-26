
package sistema.comercial.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItensVendidos extends Itens{
    private int quantidade;
    private double subtotal;
    @ManyToOne
    @JoinColumn(name = "vendas_id")
    private Vendas venda;
}
