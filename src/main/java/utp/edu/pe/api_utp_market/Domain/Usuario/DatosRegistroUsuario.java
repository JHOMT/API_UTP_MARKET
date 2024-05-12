package utp.edu.pe.api_utp_market.Domain.Usuario;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario(
        @NotNull String usuario,
        @NotNull String password,
        @NotNull Rol rol,
        @NotNull Double coin_associates
) {
}
