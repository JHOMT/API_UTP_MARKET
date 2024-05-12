package utp.edu.pe.api_utp_market.Domain.Comprobante;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosRegistroComprobante(
        @NotNull LocalDate fecha,
        @NotNull Double total,
        @NotNull int id_usuario
) {
}
