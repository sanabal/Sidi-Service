package cl.backoffice.sidi.controller;

import cl.backoffice.sidi.dto.CompraDTO;
import cl.backoffice.sidi.service.ComprasService;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Authorization;
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
@RequestMapping("/compras")
public class ComprasController {
    Logger logger = LoggerFactory.getLogger(ComprasController.class);

    @Autowired
    private ComprasService comprasService;

    @GetMapping("/listar")
    @ApiOperation(value = "Listado de Compras",authorizations = {@Authorization(value="JWT")})
    @ApiResponse(code=200,message = "OK")
    public ResponseEntity<?>listaCompras() throws Exception {
        logger.info("Consulta de listado Compras ");
        try {
            List<CompraDTO> lista = comprasService.listaCompras();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            logger.info("Problemas al listar Compras");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/detalle/{id}")
    @ApiOperation(value="Detalle de la compra: ",authorizations = {@Authorization(value="JWT")})
    @ApiResponse(code=200,message = "OK")
    public ResponseEntity<?> detalleCompra(@PathVariable @NotNull Long id) throws Exception{
        logger.info("Detalle de la compra N:" + id);
        try {
            CompraDTO detalle = comprasService.detalleCompra(id);
            return new ResponseEntity<>(detalle,HttpStatus.OK);
        }catch (Exception e){
            logger.info("Problemas al buscar detalle de la compra");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
