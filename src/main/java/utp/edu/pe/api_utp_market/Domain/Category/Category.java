package utp.edu.pe.api_utp_market.Domain.Category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_category")
    private String name;

    public Category(DatosRegistroCategory datos) {
        this.name = datos.nombre();
    }

    public Category(Long id) {
        this.id = id;
    }
}
