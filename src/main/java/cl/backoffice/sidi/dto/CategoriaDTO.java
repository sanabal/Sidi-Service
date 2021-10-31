package cl.backoffice.sidi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriaDTO {

    private Long idCategoria;
    private String descripcion;
    private Boolean estado;
    private List<?> productos;
}
