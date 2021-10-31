package cl.backoffice.sidi.controller;


import cl.backoffice.sidi.dto.CategoriaDTO;

import cl.backoffice.sidi.service.CategoriaService;

import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listaCategorias() throws Exception{
        Date date = new Date();
        SimpleDateFormat ft =new SimpleDateFormat ("dd/MM/YYYY  hh:mm:ss");

        logger.info("Consulta de listar Categorias: " + ft.format(date));
        try {
            List<CategoriaDTO> lista = categoriaService.listaCategorias();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            logger.info("Problemas al listar categorias");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<?>detalleCategoria(@PathVariable @NotNull Long id) throws Exception{
        logger.info("Detalle de la Categoria N: "+id);
        try {
            CategoriaDTO detalle = categoriaService.detalleCategoria(id);
            return new ResponseEntity<>(detalle, HttpStatus.OK);
        }catch (Exception e){
            logger.info("Problemas al ir al detalle de la categoria");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
