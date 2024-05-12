package utp.edu.pe.api_utp_market.Domain.Comprobante;

public record DatosListadoComprobante(
        Long id,
        String fecha,
        Double total,
        String usuario
) {
    public DatosListadoComprobante(Comprobante comprobante) {
        this(
                comprobante.getId(),
                comprobante.getFecha().toString(),
                comprobante.getTotal(),
                comprobante.getUsuario().getUsuario()
        );
    }
}
