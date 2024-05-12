package utp.edu.pe.api_utp_market.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.api_utp_market.Domain.Usuario.DatosListadoUsuario;
import utp.edu.pe.api_utp_market.Domain.Usuario.DatosRegistroUsuario;
import utp.edu.pe.api_utp_market.Domain.Usuario.Usuario;
import utp.edu.pe.api_utp_market.Domain.Usuario.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> newUsuario(@RequestBody @Valid DatosRegistroUsuario datos) {
        Usuario usuario = new Usuario(datos);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoUsuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<DatosListadoUsuario> datosListadoUsuarios = usuarios.stream()
                .map(DatosListadoUsuario::new)
                .collect(java.util.stream.Collectors.toList());
        return ResponseEntity.ok(datosListadoUsuarios);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DatosListadoUsuario>> buscarUsuario(@RequestParam String usuario) {
        List<Usuario> usuarios = usuarioRepository.findByUsuarioOrRol(usuario);
        List<DatosListadoUsuario> datosListadoUsuarios = usuarios.stream()
                .map(DatosListadoUsuario::new)
                .collect(java.util.stream.Collectors.toList());
        return ResponseEntity.ok(datosListadoUsuarios);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateUsuario(@RequestBody @Valid DatosRegistroUsuario datos) {
        Usuario usuario = new Usuario(datos);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado"));
        if (usuario.getCoins() > 0) {
            throw new RuntimeException("No se puede eliminar un usuario con coins");
        }
        if(usuario.getRol().equals("ADMIN")){
            throw new RuntimeException("No se puede eliminar un usuario administrador");
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }
}
