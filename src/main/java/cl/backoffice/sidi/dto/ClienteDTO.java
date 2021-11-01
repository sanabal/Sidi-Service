package cl.backoffice.sidi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteDTO {

    private String id;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;
    private String correo;
    //private List<?> compras;
}
