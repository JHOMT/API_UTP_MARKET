package utp.edu.pe.api_utp_market.Domain.Comprobante;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
//id_usuario
public record DatosRegistroComprobante(
        @NotNull LocalDate fecha,
        @NotNull Double total,
        @NotNull Long id_usuario
){
}
