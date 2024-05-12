package utp.edu.pe.api_utp_market.Domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("""
        SELECT u FROM Usuario u
        WHERE u.usuario LIKE %?1%
        OR u.rol = ?1
    """)
    List<Usuario> findByUsuarioOrRol(String usuario);

    UserDetails findByUsuario(String username);

    @Query("""
        SELECT u FROM Usuario u
        WHERE u.usuario = ?1
    """)
    UserDetails findByNombre(String nombreUsuario);
}
