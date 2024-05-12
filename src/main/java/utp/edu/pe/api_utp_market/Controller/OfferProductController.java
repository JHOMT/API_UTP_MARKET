package utp.edu.pe.api_utp_market.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.api_utp_market.Domain.Offer.Offer;
import utp.edu.pe.api_utp_market.Domain.OfferProduct.*;
import utp.edu.pe.api_utp_market.Domain.Product.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/offerproducts")
@SecurityRequirement(name = "bearer-key")
public class OfferProductController {
    @Autowired
    private OfferProductRepository offerProductRepository;

    @PostMapping
    public ResponseEntity<?> newProducto(@RequestBody @Valid DatosRegistroOfferProduct datos) {
        OfferProduct offerProduct = new OfferProduct(datos);
        offerProductRepository.save(offerProduct);
        return ResponseEntity.ok("OfferProduct created successfully!");
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoOfertaProduct>> listOfferProducts() {
        List<OfferProduct> offerProducts = offerProductRepository.findAll();
        List<DatosListadoOfertaProduct> response = offerProducts.stream()
                .map(DatosListadoOfertaProduct::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DatosListadoOfertaProduct>> searchOfferProduct(@RequestParam String offer) {
        List<OfferProduct> offerProducts = offerProductRepository.findBySearchCriteria(offer);
        List<DatosListadoOfertaProduct> response = offerProducts.stream()
                .map(DatosListadoOfertaProduct::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateOfferProduct(@RequestBody @Valid DatosActualizarOfferProduct datos) {
        Optional<OfferProduct> offerProductOptional = offerProductRepository.findByOffer_IdAndProduct_Id(datos.offerID(), datos.productID());
        if (offerProductOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        OfferProduct offerProduct = offerProductOptional.get();
        offerProduct.setOffer(new Offer(datos.offerID()));
        offerProduct.setProduct(new Product(datos.productID()));
        offerProductRepository.save(offerProduct);
        return ResponseEntity.ok("OfferProduct updated successfully!");
    }

    @DeleteMapping("/{idOffer}/{idProduct}")
    @Transactional
    public ResponseEntity<?> deleteOfferProduct(@PathVariable Long idOffer, @PathVariable Long idProduct) {
        Optional<OfferProduct> offerProductOptional = offerProductRepository.findByOffer_IdAndProduct_Id(idOffer, idProduct);
        if (offerProductOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        offerProductRepository.delete(offerProductOptional.get());
        return ResponseEntity.ok("OfferProduct deleted successfully!");
    }
}
