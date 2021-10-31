package cl.backoffice.sidi.controller;

import cl.backoffice.sidi.dto.ClienteDTO;
import cl.backoffice.sidi.service.ClienteService;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    @ApiOperation("Listado de Clientes")
    @ApiResponse(code=200,message = "OK")
    public ResponseEntity<?> listaClientes()throws Exception{
        logger.info("Consulta de listado de clientes ");
        try {
            List<ClienteDTO> lista= clienteService.listaClientes();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            logger.info("Problemas al listar Clientes");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/detalle/{id}")
    @ApiOperation("Detalle de Cliente: ")
    @ApiResponse(code=200,message = "OK")
    public ResponseEntity<?> detalleCliente(@PathVariable @NotNull String id) throws Exception{

        logger.info("Detalle del Cliente N:" + id);
        try {
            ClienteDTO detalle = clienteService.detalleCliente(id);
            return new ResponseEntity<>(detalle,HttpStatus.OK);
        }catch (Exception e){
            logger.info("Problemas al buscar detalle del cliente");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
