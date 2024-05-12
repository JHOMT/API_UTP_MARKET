package utp.edu.pe.api_utp_market.Domain.Comprobante;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosActualizarComprobante(
        @NotNull Long id,
        LocalDate fecha,
        Double total,
        Long id_usuario
) {
}
