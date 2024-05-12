package utp.edu.pe.api_utp_market.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.api_utp_market.Domain.Product.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
@SecurityRequirement(name = "bearer-key")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<?> registrarProducto(@RequestBody @Valid DatosRegistroProduct datos) {
        Product product = new Product(datos);
        productRepository.save(product);
        return ResponseEntity.ok("Producto registrado correctamente");
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoProduct>> listarProductos() {
        List<Product> products = productRepository.findAll();
        List<DatosListadoProduct> response = products.stream()
                .map(DatosListadoProduct::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DatosListadoProduct>> buscarProducto(@RequestParam String nombre) {
        List<Product> products = productRepository.findNameAll(nombre);
        List<DatosListadoProduct> response = products.stream()
                .map(DatosListadoProduct::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateProduct(@RequestBody @Valid DatosActualizarProduct datos) {
        Product product = new Product(datos);
        productRepository.save(product);
        return ResponseEntity.ok("Producto actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
