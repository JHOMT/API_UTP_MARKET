package utp.edu.pe.api_utp_market.Domain.Comprobante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {
    @Query("""
        SELECT c FROM Comprobante c
        JOIN c.usuario u
        WHERE u.usuario LIKE %:buscar%
    """)
    List<Comprobante> findByUsuarioNombreContaining(String buscar);
}
