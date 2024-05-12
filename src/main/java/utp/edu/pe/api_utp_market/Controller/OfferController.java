package utp.edu.pe.api_utp_market.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.api_utp_market.Domain.Offer.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/offer")
@SecurityRequirement(name = "bearer-key")
public class OfferController {
    @Autowired
    private OfferRepository offerRepository;

    @PostMapping
    public ResponseEntity<?> newOffer(@RequestBody @Valid DatosRegistroOffer datos){
        Offer newOffer = new Offer(datos);
        offerRepository.save(newOffer);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoOffert>> getAllOffers(){
        List<Offer> offersList = offerRepository.findAll();
        List<DatosListadoOffert> response = offersList.stream()
                .map(DatosListadoOffert::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DatosListadoOffert>> searchOffer(@RequestParam String name){
        Optional<Offer> offersList = offerRepository.findByName(name);
        if (offersList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<DatosListadoOffert> response = offersList.stream()
                .map(DatosListadoOffert::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateOffer(@RequestBody @Valid DatosActualizarOffer datos){
        Optional<Offer> offer = offerRepository.findByName(datos.name());
        if (offer.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Offer offerToUpdate = offer.get();
        offerToUpdate.setName(datos.name());
        offerToUpdate.setDescuento(datos.descuento());
        offerRepository.save(offerToUpdate);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteOffer(@PathVariable Long id){
        Optional<Offer> offer = offerRepository.findById(id);
        if (offer.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        offerRepository.delete(offer.get());
        return ResponseEntity.ok().build();
    }
}
