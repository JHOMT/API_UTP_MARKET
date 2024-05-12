package utp.edu.pe.api_utp_market.Domain.Comprobante;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.api_utp_market.Domain.Usuario.Usuario;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private Double total;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Comprobante(DatosRegistroComprobante datos) {
        this.fecha = datos.fecha();
        this.total = datos.total();
    }

    public Comprobante(DatosActualizarComprobante datos) {
        if (datos.id() != 0){
            this.id = datos.id();
        }
        if (datos.fecha() != null){
            this.fecha = datos.fecha();
        }
        if (datos.total() != 0){
            this.total = datos.total();
        }
        if (datos.id_usuario() != 0){
            this.usuario = new Usuario(datos.id_usuario());
        }
    }

    public Comprobante(Long id) {
        this.id = id;
    }
}
