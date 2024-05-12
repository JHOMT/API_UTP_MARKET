package utp.edu.pe.api_utp_market.Domain.Category;

public record DatosListadoCategory(
        Long categoryID,
        String nombre
) {
    public DatosListadoCategory(Category category) {
        this(
                category.getId(),
                category.getName()
        );
    }
}
