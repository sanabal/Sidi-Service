package cl.backoffice.sidi.service;


import cl.backoffice.sidi.dto.ProductoDTO;
import cl.backoffice.sidi.model.ProductoModel;
import cl.backoffice.sidi.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestionProductoServiceImpl implements  GestionProductoService, InitializingBean {

    Logger logger = LoggerFactory.getLogger(GestionProductoServiceImpl.class);

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
    }

    public List<ProductoDTO> listaProductos() throws Exception{
        List<ProductoDTO> listaDTO = new ArrayList<ProductoDTO>();
        List<ProductoModel> lista = null;
        try{
         lista = productoRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        for (ProductoModel product:lista){
            listaDTO.add(transformacionDTO(product));
        }

        return listaDTO;
    }

    @Override
    public ProductoDTO detalleProducto(Long id) throws Exception {
        ProductoDTO detalleDTO=null;
        try {
            ProductoModel producto = productoRepository.getById(id);
             detalleDTO = transformacionDTO(producto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return detalleDTO;
    }

    private ProductoDTO transformacionDTO(ProductoModel product) {
        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setIdProducto(product.getIdProducto());
        productoDTO.setIdCategoria(product.getIdCategoria());
        productoDTO.setNombre(product.getNombre());
        productoDTO.setCantidadStock(product.getCantidadStock());
        productoDTO.setEstado(product.getEstado());
        productoDTO.setPrecioVenta(product.getPrecioVenta());
        productoDTO.setCodigoBarras(product.getCodigoBarras());

        return productoDTO;
    }
}
