package utp.edu.pe.api_utp_market.Domain.DetalleCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {
    @Query("""
        SELECT dc FROM DetalleCompra dc
        JOIN dc.product p
        WHERE p.name LIKE %:nombre%
    """)
    List<DetalleCompra> findByNombreAll(String nombre);
}
