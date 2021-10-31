package cl.backoffice.sidi.controller;

import cl.backoffice.sidi.model.ClienteModel;
import cl.backoffice.sidi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<?> listaClientes(){
        List<ClienteModel> lista= clienteService.listaClientes();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
