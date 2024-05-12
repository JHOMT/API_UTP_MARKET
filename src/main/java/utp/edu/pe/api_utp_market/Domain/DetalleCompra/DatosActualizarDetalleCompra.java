package utp.edu.pe.api_utp_market.Domain.DetalleCompra;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarDetalleCompra(
        @NotNull Long id_detalle,
        Long id_comprobante,
        Long id_product,
        Integer cantidad,
        Integer precio,
        Boolean estado_entrega,
        Boolean estado_pago
) {
}
