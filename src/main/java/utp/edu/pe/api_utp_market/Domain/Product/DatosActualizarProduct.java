package utp.edu.pe.api_utp_market.Domain.Product;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarProduct(
        @NotNull Long id,
        String name,
        String description,
        int stock,
        Double coin,
        Double price,
        Long idCategory
) {
}
