package cl.backoffice.sidi.controller;

import cl.backoffice.sidi.model.ProductoModel;
import cl.backoffice.sidi.service.GestionProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class GestionProductoController {

    @Autowired
    private GestionProductoService gestionProductoService;

    @GetMapping("/listar")
    @ApiOperation("Listado de Productos")
    @ApiResponse(code=200,message = "OK")
    public ResponseEntity<?> listaProductos(){
        List<ProductoModel> listar = gestionProductoService.listaProductos();

        return new ResponseEntity<>(listar, HttpStatus.OK);
    }

}
