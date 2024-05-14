package utp.edu.pe.api_utp_market.Domain.Usuario;

public record DatosListadoUsuario(
        Long usuarioID,
        String usuario,
        String rol,
        Double coins
) {
    public DatosListadoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getUsuario(),
                usuario.getRol().toString(),
                usuario.getCoins()
        );
    }
}
