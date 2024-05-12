package utp.edu.pe.api_utp_market.Domain.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column(name = "coin_associates")
    private Double coins;

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(DatosRegistroUsuario datos) {
        this.usuario = datos.usuario();
        this.password = datos.password();
        this.rol = datos.rol();
        this.coins = datos.coin_associates();
    }

    public Usuario(DatosActualizarUsuario datos) {
        if (datos.id() != null) {
            this.id = datos.id();
        }
        if (datos.usuario() != null) {
            this.usuario = datos.usuario();
        }
        if (datos.password() != null) {
            this.password = datos.password();
        }
        if (datos.rol() != null) {
            this.rol = Rol.valueOf(datos.rol());
        }
        if (datos.coins() != null) {
            this.coins = datos.coins();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE-USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
