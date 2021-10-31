package cl.backoffice.sidi.controller;

import cl.backoffice.sidi.model.CompraModel;
import cl.backoffice.sidi.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @GetMapping("/listar")
    public ResponseEntity<?>listaCompras(){
        List<CompraModel> lista = comprasService.listaCompras();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
