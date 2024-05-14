package utp.edu.pe.api_utp_market.Domain.Usuario;

public record DatosListadoUsuario(
        Long usuarioID,
        String usuario,
        String password,
        String rol,
        Double coins
) {
    public DatosListadoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getUsuario(),
                usuario.getPassword(),
                usuario.getRol().toString(),
                usuario.getCoins()
        );
    }
}
