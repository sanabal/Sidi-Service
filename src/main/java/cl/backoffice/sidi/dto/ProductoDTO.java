package cl.backoffice.sidi.dto;

import cl.backoffice.sidi.model.CategoriaModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductoDTO {

    private Long idProducto;
    private Long idCategoria;
    private String nombre;
    private String codigoBarras;
    private BigDecimal precioVenta;
    private Long cantidadStock;
    private Boolean estado;
}
