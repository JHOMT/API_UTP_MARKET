package utp.edu.pe.api_utp_market.Domain.Offer;

public record DatosListadoOffert(
        Long id,
        String name,
        Double descuento
) {
    public DatosListadoOffert(Offer offer) {
        this(
                offer.getId(),
                offer.getName(),
                offer.getDescuento()
        );
    }
}
