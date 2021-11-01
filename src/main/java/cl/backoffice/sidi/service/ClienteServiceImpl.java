package cl.backoffice.sidi.service;

import cl.backoffice.sidi.dto.ClienteDTO;
import cl.backoffice.sidi.model.ClienteModel;
import cl.backoffice.sidi.repository.ClienteRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements  ClienteService , InitializingBean {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public List<ClienteDTO> listaClientes() throws Exception{
        List<ClienteDTO> listaDTO = new ArrayList<ClienteDTO>();
        List<ClienteModel> clientes=null;
        try{
            clientes = clienteRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        for (ClienteModel cliente:clientes){
            listaDTO.add(transformacionDTO(cliente));

        }
        return listaDTO;
    }

    @Override
    public ClienteDTO detalleCliente(String id) throws Exception {
        ClienteModel cliente = null;
        ClienteDTO clienteDTO=null;
        try{
            cliente = clienteRepository.getById(id);
            clienteDTO = transformacionDTO(cliente);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return clienteDTO;
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO cliente) throws Exception {
        ClienteModel clienteModel = transfomracionModel(cliente);
        ClienteModel clienteSave = null;
        ClienteDTO clienteDTO = null;
        try{
            clienteSave = clienteRepository.save(clienteModel);
            clienteDTO = transformacionDTO(clienteSave);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return clienteDTO;
    }

    private ClienteDTO transformacionDTO(ClienteModel cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellidos(cliente.getApellidos());
        clienteDTO.setCorreo(cliente.getCorreoElectronico());
        clienteDTO.setCelular(cliente.getCelular());
        clienteDTO.setDireccion(cliente.getDireccion());



        return clienteDTO;
    }

    private ClienteModel transfomracionModel(ClienteDTO clienteDTO){
        ClienteModel clienteModel = new ClienteModel();

        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNombre(clienteDTO.getNombre());
        clienteModel.setApellidos(clienteDTO.getApellidos());
        clienteModel.setDireccion(clienteDTO.getDireccion());
        clienteModel.setCelular(clienteDTO.getCelular());
        clienteModel.setCorreoElectronico(clienteDTO.getCorreo());

        return clienteModel;

    }
}
