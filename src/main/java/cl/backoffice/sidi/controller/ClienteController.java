package cl.backoffice.sidi.controller;

import cl.backoffice.sidi.dto.ClienteDTO;
import cl.backoffice.sidi.service.ClienteService;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    @ApiOperation(value = "Listado de Clientes",authorizations = {@Authorization(value="JWT")})
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
    @ApiOperation(value = "Detalle de Cliente: ",authorizations = {@Authorization(value="JWT")})
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

    @PostMapping("/guardar-cliente")
    @ApiOperation(value = "Guardar Cliente",authorizations = {@Authorization(value="JWT")})
    @ApiResponse(code=200, message ="OK")
    public ResponseEntity<?> guardarCliente(@RequestBody ClienteDTO cliente) throws Exception{
        logger.info("Guardar Cliente");
        try {
            ClienteDTO clienteCreado =clienteService.crearCliente(cliente);
            return new ResponseEntity<>(clienteCreado,HttpStatus.CREATED);
        }catch (Exception e){
            logger.info("Problemas al Guardar el cliente");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
