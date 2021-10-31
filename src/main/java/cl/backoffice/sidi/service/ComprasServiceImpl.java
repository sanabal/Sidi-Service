package cl.backoffice.sidi.service;

import cl.backoffice.sidi.model.CompraModel;
import cl.backoffice.sidi.repository.CompraRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprasServiceImpl implements ComprasService, InitializingBean {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public List<CompraModel> listaCompras() {
        List<CompraModel> lista = compraRepository.findAll();
        return lista;
    }
}
