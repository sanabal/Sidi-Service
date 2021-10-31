package cl.backoffice.sidi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CompraDTO {

    private Long idCompra;
    private String idCliente;
    private LocalDateTime fecha;
    private String medioPago;
    private String comentario;
    private String estado;
    /*private List<?> cliente;
    private List<?> Comprasproductos;*/
}
