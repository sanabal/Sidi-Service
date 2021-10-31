package cl.backoffice.sidi.service;

import cl.backoffice.sidi.dto.CategoriaDTO;


import java.util.List;

public interface CategoriaService {

    List<CategoriaDTO> listaCategorias() throws Exception;

    CategoriaDTO detalleCategoria(Long id) throws Exception;

}
