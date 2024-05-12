package utp.edu.pe.api_utp_market.Domain.Offer;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarOffer(
        @NotNull Long id,
        String name,
        Double descuento
) {
}
