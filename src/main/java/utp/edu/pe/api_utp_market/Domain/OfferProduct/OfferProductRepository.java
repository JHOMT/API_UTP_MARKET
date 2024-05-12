package utp.edu.pe.api_utp_market.Domain.OfferProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OfferProductRepository extends JpaRepository<OfferProduct, OfferProductId> {
    @Query("""
        SELECT op FROM OfferProduct op
        JOIN op.offer o
        JOIN op.product p
        WHERE o.name LIKE %:searchCriteria%
        OR p.name LIKE %:searchCriteria%
        OR o.descuento = :searchCriteria
    """)
    List<OfferProduct> findBySearchCriteria(String searchCriteria);

    @Query("""
        SELECT op FROM OfferProduct op
        WHERE op.id.offer = :idOffer
        AND op.id.product = :idProduct
    """)
    Optional<OfferProduct> findByOffer_IdAndProduct_Id(Long idOffer, Long idProduct);
}
