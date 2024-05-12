package utp.edu.pe.api_utp_market.Domain.OfferProduct;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OfferProductId implements Serializable {
    private Long offer;
    private Long product;
}
