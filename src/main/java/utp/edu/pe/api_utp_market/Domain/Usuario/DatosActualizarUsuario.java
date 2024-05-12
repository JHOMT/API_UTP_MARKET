package utp.edu.pe.api_utp_market.Domain.Usuario;

public record DatosActualizarUsuario(
        Long id,
        String usuario,
        String password,
        String rol,
        Double coins
) {
}
