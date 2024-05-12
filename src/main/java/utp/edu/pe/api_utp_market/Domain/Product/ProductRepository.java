package utp.edu.pe.api_utp_market.Domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
        SELECT p FROM Product p
        JOIN p.category c
        WHERE p.name LIKE %:nombre%
        OR p.description LIKE %:nombre%
        OR c.name LIKE %:nombre%
    """)
    List<Product> findNameAll(String nombre);
}
