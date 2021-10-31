package cl.backoffice.sidi.controller;


import cl.backoffice.sidi.dto.CategoriaDTO;

import cl.backoffice.sidi.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listaCategorias(){
        List<CategoriaDTO> lista = categoriaService.listaCategorias();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
