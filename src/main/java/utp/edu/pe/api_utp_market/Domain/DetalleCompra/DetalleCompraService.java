package utp.edu.pe.api_utp_market.Domain.DetalleCompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.api_utp_market.Domain.Comprobante.ComprobanteRepository;
import utp.edu.pe.api_utp_market.Domain.DetalleCompra.Validators.ValidatorDetalleCompra;
import utp.edu.pe.api_utp_market.Domain.Product.ProductRepository;

import java.util.List;

@Service
public class DetalleCompraService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;
    @Autowired
    private ComprobanteRepository comprobanteRepository;
    @Autowired
    private List<ValidatorDetalleCompra> validators;

    public void save(DatosRegistroDetalleCompra datos){
        for(ValidatorDetalleCompra validator: validators){
            validator.validate(datos);
        }
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setComprobante(comprobanteRepository.findById(datos.id_comprobante()).get());
        detalleCompra.setCantidad(datos.cantidad());
        detalleCompra.setPrecio(datos.precio());
        detalleCompra.setEstado_entrega(datos.estado_entrega());
        detalleCompra.setEstado_pago(datos.estado_pago());
        detalleCompra.setCantidad(datos.cantidad());
        detalleCompra.setPrecio(datos.precio());
        detalleCompra.setProduct(productRepository.findById(datos.id_producto()).get());
        detalleCompraRepository.save(detalleCompra);
    }
}
