package utp.edu.pe.api_utp_market.Domain.Offer;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroOffer(
        @NotNull String name,
        @NotNull Double descuento
) {
}
