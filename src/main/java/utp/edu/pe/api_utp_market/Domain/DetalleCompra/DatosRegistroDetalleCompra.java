package utp.edu.pe.api_utp_market.Domain.DetalleCompra;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroDetalleCompra(
        @NotNull Long id_comprobante,
        @NotNull Long id_producto,
        @NotNull int cantidad,
        @NotNull double precio,
        @NotNull Boolean estado_entrega,
        @NotNull Boolean estado_pago
) {
}
