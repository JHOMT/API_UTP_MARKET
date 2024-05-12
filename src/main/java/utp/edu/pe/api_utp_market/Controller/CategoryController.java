package utp.edu.pe.api_utp_market.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.api_utp_market.Domain.Category.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@SecurityRequirement(name = "bearer-key")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<?> newCategory(@RequestBody @Valid DatosRegistroCategory datos){
        Category newCategory = new Category(datos);
        categoryRepository.save(newCategory);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoCategory>> getAllCategories(){
        List<Category> categoriesList = categoryRepository.findAll();
        List<DatosListadoCategory> response = categoriesList.stream()
                .map(DatosListadoCategory::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> getCategory(@RequestParam String buscar){
        List<Category> categoryOptional = categoryRepository.findByNombreContaining(buscar);
        List<DatosListadoCategory> response = categoryOptional.stream()
                .map(DatosListadoCategory::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateCategory(@RequestBody @Valid DatosActualizarCategory datos) {
        Optional<Category> categoryOptional = categoryRepository.findById(datos.id());
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(datos.nombre());
            categoryRepository.save(category);
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
