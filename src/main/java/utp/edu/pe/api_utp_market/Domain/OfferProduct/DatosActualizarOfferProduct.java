package utp.edu.pe.api_utp_market.Domain.OfferProduct;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarOfferProduct(
        @NotNull Long offerID,
        @NotNull Long productID
) {
}
