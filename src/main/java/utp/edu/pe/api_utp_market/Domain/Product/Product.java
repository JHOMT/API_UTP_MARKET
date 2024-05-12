package utp.edu.pe.api_utp_market.Domain.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.api_utp_market.Domain.Category.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int stock;
    private Double coin;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    private Category category;

    public Product(Long id) {
        this.id = id;
    }

    public Product(DatosRegistroProduct datos) {
        this.name = datos.name();
        this.description = datos.description();
        this.stock = datos.stock();
        this.coin = datos.coin();
        this.price = datos.price();
    }

    public Product(DatosActualizarProduct datos) {
        this.id = datos.id();
        this.name = datos.name();
        this.description = datos.description();
        this.stock = datos.stock();
        this.coin = datos.coin();
        this.price = datos.price();
        this.category = new Category(datos.idCategory());
    }
}
