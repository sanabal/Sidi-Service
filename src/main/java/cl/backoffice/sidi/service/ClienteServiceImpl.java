package cl.backoffice.sidi.service;

import cl.backoffice.sidi.model.ClienteModel;
import cl.backoffice.sidi.repository.ClienteRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements  ClienteService , InitializingBean {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public List<ClienteModel> listaClientes() {
        List<ClienteModel> clientes = clienteRepository.findAll();
        return clientes;
    }
}
