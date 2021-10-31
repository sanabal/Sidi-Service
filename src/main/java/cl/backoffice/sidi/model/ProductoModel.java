package cl.backoffice.sidi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name="productos")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    private String nombre;
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_categoria",insertable = false, updatable = false)
    private CategoriaModel categoriaProducto;

    @Column(name="codigo_barras")
    private String codigoBarras;

    @Column(name="precio_venta")
    private BigDecimal precioVenta;

    @Column(name="cantidad_stock")
    private Long cantidadStock;

    private Boolean estado;


}
