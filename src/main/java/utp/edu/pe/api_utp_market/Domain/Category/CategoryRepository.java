package utp.edu.pe.api_utp_market.Domain.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("""
        SELECT c FROM Category c
        WHERE c.name LIKE %:buscar%
    """)
    List<Category> findByNombreContaining(String buscar);
}
