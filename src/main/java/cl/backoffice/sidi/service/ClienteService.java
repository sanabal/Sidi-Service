package cl.backoffice.sidi.service;

import cl.backoffice.sidi.dto.ClienteDTO;
import cl.backoffice.sidi.model.ClienteModel;

import java.util.List;


public interface ClienteService {

    List<ClienteDTO> listaClientes() throws Exception;

    ClienteDTO detalleCliente(String id) throws  Exception;
}
