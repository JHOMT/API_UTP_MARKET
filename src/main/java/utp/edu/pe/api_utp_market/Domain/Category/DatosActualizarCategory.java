package utp.edu.pe.api_utp_market.Domain.Category;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCategory(
        @NotNull Long id,
        String nombre
) {
}
