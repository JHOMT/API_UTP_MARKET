package utp.edu.pe.api_utp_market.Domain.Offer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<Offer> findByName(String name);
}
