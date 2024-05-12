package utp.edu.pe.api_utp_market.Domain.OfferProduct;

public record DatosListadoOfertaProduct(
        Long offerID,
        Long productID
) {
    public DatosListadoOfertaProduct(OfferProduct offerProduct) {
        this(
                offerProduct.getOffer().getId(),
                offerProduct.getProduct().getId()
        );
    }
}
