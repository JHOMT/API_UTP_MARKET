package utp.edu.pe.api_utp_market.Domain.DetalleCompra;

public record DatosListadoDetalleCompra(
        Long detalleCompraID,
        Long comprobanteID,
        Long productoID,
        int cantidad,
        double precio,
        Boolean estado_entrega,
        Boolean estado_pago
) {
    public DatosListadoDetalleCompra(DetalleCompra detalleCompra) {
        this(
                detalleCompra.getId(),
                detalleCompra.getComprobante().getId(),
                detalleCompra.getProduct().getId(),
                detalleCompra.getCantidad(),
                detalleCompra.getPrecio(),
                detalleCompra.getEstado_entrega(),
                detalleCompra.getEstado_pago()
        );
    }
}
