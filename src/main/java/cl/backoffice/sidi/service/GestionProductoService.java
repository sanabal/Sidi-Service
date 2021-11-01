package cl.backoffice.sidi.service;

import cl.backoffice.sidi.dto.ProductoDTO;

import java.util.List;

public interface GestionProductoService {

    List<ProductoDTO> listaProductos() throws Exception;
    ProductoDTO detalleProducto(Long id) throws Exception;
}
