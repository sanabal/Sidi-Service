package cl.backoffice.sidi.controller;

import cl.backoffice.sidi.dto.ProductoDTO;
import cl.backoffice.sidi.model.ProductoModel;
import cl.backoffice.sidi.service.GestionProductoService;
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
@RequestMapping("/producto")
public class GestionProductoController {

    Logger logger = LoggerFactory.getLogger(GestionProductoController.class);
    @Autowired
    private GestionProductoService gestionProductoService;

    @GetMapping("/listar")
    @ApiOperation("Listado de Productos")
    @ApiResponse(code=200,message = "OK")
    public ResponseEntity<?> listaProductos(){

        logger.info("Consulta de listar Productos ");
        try {
            List<ProductoDTO> listar = gestionProductoService.listaProductos();
            return new ResponseEntity<>(listar, HttpStatus.OK);
        }catch (Exception e){
            logger.info("Problemas al listar Productos");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/detalle/{id}")
    @ApiOperation("Detalle de Producto: ")
    @ApiResponse(code=200,message = "OK")
    public ResponseEntity<?> detalleProducto(@PathVariable @NotNull Long id){

        logger.info("Detalle del Producto N:" + id);
        try {
            ProductoDTO detalle = gestionProductoService.detalleProducto(id);
            return new ResponseEntity<>(detalle,HttpStatus.OK);
        }catch (Exception e){
            logger.info("Problemas al listar Productos");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
