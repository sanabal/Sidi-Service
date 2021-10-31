package cl.backoffice.sidi.service;

import cl.backoffice.sidi.dto.CompraDTO;
import cl.backoffice.sidi.model.CompraModel;

import java.util.List;

public interface ComprasService {

    List<CompraDTO> listaCompras() throws Exception;

    CompraDTO detalleCompra(Long id) throws Exception;
}
