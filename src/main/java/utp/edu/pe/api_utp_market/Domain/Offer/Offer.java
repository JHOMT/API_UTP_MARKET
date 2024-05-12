package utp.edu.pe.api_utp_market.Domain.Offer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_offer")
    private String name;
    private Double descuento;

    public Offer(DatosRegistroOffer datos) {
        this.name = datos.name();
        this.descuento = datos.descuento();
    }

    public Offer(Long id) {
        this.id = id;
    }
}
