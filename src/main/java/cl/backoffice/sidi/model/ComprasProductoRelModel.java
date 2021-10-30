package cl.backoffice.sidi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class ComprasProductoRelModel {
    @EmbeddedId
    private ComprasProductoPK id;

    private Long cantidad;
    private BigDecimal total;
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private CompraModel compra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductoModel producto;




}
