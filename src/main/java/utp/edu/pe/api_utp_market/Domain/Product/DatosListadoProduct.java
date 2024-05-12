package utp.edu.pe.api_utp_market.Domain.Product;

public record DatosListadoProduct(
        Long id,
        String name,
        String description,
        Integer stock,
        Double coin,
        Double price,
        String id_category
) {
    public DatosListadoProduct(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStock(),
                product.getCoin(),
                product.getPrice(),
                product.getCategory().getName()
        );
    }
}
