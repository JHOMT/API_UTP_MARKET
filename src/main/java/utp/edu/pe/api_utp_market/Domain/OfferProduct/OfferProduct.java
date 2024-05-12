package utp.edu.pe.api_utp_market.Domain.OfferProduct;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.api_utp_market.Domain.Offer.Offer;
import utp.edu.pe.api_utp_market.Domain.Product.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offer_product")
public class OfferProduct {
    @EmbeddedId
    private OfferProductId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_offer", insertable = false, updatable = false)
    private Offer offer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    public OfferProduct(DatosRegistroOfferProduct datos) {
        this.offer = new Offer(datos.offerID());
        this.product = new Product(datos.productID());
    }
}
