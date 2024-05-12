package utp.edu.pe.api_utp_market.Domain.Usuario;

import jakarta.validation.constraints.NotNull;

public record DatosLoginUsuario(
        @NotNull
        String nombre,
        @NotNull
        String password
) {
}

