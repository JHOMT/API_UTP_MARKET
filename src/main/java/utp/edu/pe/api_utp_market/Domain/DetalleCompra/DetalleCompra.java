package utp.edu.pe.api_utp_market.Domain.DetalleCompra;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.api_utp_market.Domain.Comprobante.Comprobante;
import utp.edu.pe.api_utp_market.Domain.Product.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comprobante")
    private Comprobante comprobante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Product product;

    private int cantidad;

    @Column(name = "precio_unit")
    private double precio;

    private Boolean estado_entrega;
    private Boolean estado_pago;

    public DetalleCompra(DatosActualizarDetalleCompra datos) {
        if (datos.id_detalle() != null) {
            this.id = datos.id_detalle();
        }
        if (datos.id_comprobante() != null) {
            this.comprobante = new Comprobante(datos.id_comprobante());
        }
        if (datos.id_product() != null) {
            this.product = new Product(datos.id_product());
        }
        if (datos.cantidad() > 0) {
            this.cantidad = datos.cantidad();
        }
        if (datos.precio() != null) {
            this.precio = datos.precio();
        }
        if (datos.estado_entrega() != null) {
            this.estado_entrega = datos.estado_entrega();
        }
        if (datos.estado_pago() != null) {
            this.estado_pago = datos.estado_pago();
        }

    }
}
