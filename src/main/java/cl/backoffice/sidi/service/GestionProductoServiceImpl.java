package cl.backoffice.sidi.service;


import cl.backoffice.sidi.model.ProductoModel;
import cl.backoffice.sidi.repository.ProductoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;

@Service
public class GestionProductoServiceImpl implements  GestionProductoService, InitializingBean {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
    }

    public List<ProductoModel> listaProductos(){
        List<ProductoModel>  lista = productoRepository.findAll();

        return lista;
    }
}
