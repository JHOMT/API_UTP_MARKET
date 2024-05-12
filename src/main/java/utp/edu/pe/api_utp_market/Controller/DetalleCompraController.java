package utp.edu.pe.api_utp_market.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.api_utp_market.Domain.DetalleCompra.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detallecompra")
@SecurityRequirement(name = "bearer-key")
public class DetalleCompraController {
    @Autowired
    private DetalleCompraService detalleCompraService;
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @PostMapping
    public ResponseEntity<?> newDetalleCompra(@RequestBody @Valid DatosRegistroDetalleCompra datos) {
        detalleCompraService.save(datos);
        return ResponseEntity.ok("Detalle de compra registrado");
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoDetalleCompra>> getAllDetalleCompra(){
        List<DetalleCompra> detalleCompras = detalleCompraRepository.findAll();
        List<DatosListadoDetalleCompra> response = detalleCompras.stream()
                .map(DatosListadoDetalleCompra::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DatosListadoDetalleCompra>> buscarDetalleCompra(@RequestParam String nombre) {
        List<DetalleCompra> detalleCompras = detalleCompraRepository.findByNombreAll(nombre);
        List<DatosListadoDetalleCompra> datosListadoDetalleCompras = detalleCompras.stream()
                .map(DatosListadoDetalleCompra::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(datosListadoDetalleCompras);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateDetalleCompra(@RequestBody @Valid DatosActualizarDetalleCompra datos) {
        DetalleCompra detalleCompra = new DetalleCompra(datos);
        detalleCompraRepository.save(detalleCompra);
        return ResponseEntity.ok("Detalle de compra actualizado");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteDetalleCompra(@RequestParam Long id) {
        detalleCompraRepository.deleteById(id);
        return ResponseEntity.ok("Detalle de compra eliminado");
    }
}
