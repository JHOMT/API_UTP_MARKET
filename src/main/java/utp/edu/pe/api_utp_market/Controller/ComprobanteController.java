package utp.edu.pe.api_utp_market.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.api_utp_market.Domain.Comprobante.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comprobante")
@SecurityRequirement(name = "bearer-key")
public class ComprobanteController {
    @Autowired
    private ComprobanteRepository comprobanteRepository;

    @PostMapping
    public ResponseEntity<?> newComprobante(@RequestBody @Valid DatosRegistroComprobante datos){
        Comprobante newComprobante = new Comprobante(datos);
        comprobanteRepository.save(newComprobante);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoComprobante>> getAllComprobantes(){
        List<Comprobante> comprobantesList = comprobanteRepository.findAll();
        List<DatosListadoComprobante> response = comprobantesList.stream()
                .map(DatosListadoComprobante::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> getComprobante(@RequestParam String buscar){
        List<Comprobante> comprobanteOptional = comprobanteRepository.findByUsuarioNombreContaining(buscar);
        List<DatosListadoComprobante> response = comprobanteOptional.stream()
                .map(DatosListadoComprobante::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateComprobante(@RequestBody @Valid DatosActualizarComprobante datos) {
        Comprobante comprobante = new Comprobante(datos);
        comprobanteRepository.save(comprobante);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteComprobante(@RequestParam Long id) {
        comprobanteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}