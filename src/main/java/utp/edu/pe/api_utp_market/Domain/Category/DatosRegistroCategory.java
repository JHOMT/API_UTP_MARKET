package utp.edu.pe.api_utp_market.Domain.Category;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroCategory(
        @NotNull String nombre
) {
    public DatosRegistroCategory {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la categoria no puede estar vacio");
        }
    }
}
