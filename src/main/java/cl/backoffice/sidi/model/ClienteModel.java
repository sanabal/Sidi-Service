package cl.backoffice.sidi.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="clientes")
public class ClienteModel {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;

    @Column(name="correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<CompraModel> compras;
}
