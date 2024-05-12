package utp.edu.pe.api_utp_market.Domain.Product;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroProduct(
        @NotNull String name,
        @NotNull String description,
        @NotNull Integer stock,
        @NotNull Double coin,
        @NotNull Double price,
        @NotNull Long id_category
) {
}
