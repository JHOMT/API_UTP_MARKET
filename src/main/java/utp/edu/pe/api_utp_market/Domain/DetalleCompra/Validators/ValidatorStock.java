package utp.edu.pe.api_utp_market.Domain.DetalleCompra.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utp.edu.pe.api_utp_market.Domain.DetalleCompra.DatosRegistroDetalleCompra;
import utp.edu.pe.api_utp_market.Domain.Product.Product;
import utp.edu.pe.api_utp_market.Domain.Product.ProductRepository;

import java.util.Optional;

@Component
public class ValidatorStock implements ValidatorDetalleCompra{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void validate(DatosRegistroDetalleCompra datos) {
        Optional<Product> product = productRepository.findById(datos.id_producto());
        if(product.isPresent()){
            if(product.get().getStock() < datos.cantidad()){
                throw new RuntimeException("No hay suficiente stock para el producto");
            }else {
                product.get().setStock(product.get().getStock() - datos.cantidad());
                productRepository.save(product.get());
            }
        }else {
            throw new RuntimeException("El producto no existe en la base de datos");
        }
    }
}
