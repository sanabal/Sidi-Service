package cl.backoffice.sidi.service;

import cl.backoffice.sidi.dto.CategoriaDTO;
import cl.backoffice.sidi.model.CategoriaModel;
import cl.backoffice.sidi.repository.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements  CategoriaService, InitializingBean {

   Logger logger = LoggerFactory.getLogger(CategoriaServiceImpl.class);

   @Autowired
   private CategoriaRepository categoriaRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public List<CategoriaDTO> listaCategorias() throws Exception {
        List<CategoriaDTO> listaDTO= new ArrayList<CategoriaDTO>();
        List<CategoriaModel> listar =null;
        try {
            listar =categoriaRepository.findAll();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        for (CategoriaModel category:listar){

            listaDTO.add(transformacionDTO(category));
        }
        return listaDTO;
    }

    @Override
    public CategoriaDTO detalleCategoria(Long id) throws Exception {
        CategoriaDTO categoriaDTO= null;
        try {
            CategoriaModel categoria = categoriaRepository.getById(id);
             categoriaDTO = transformacionDTO(categoria);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return categoriaDTO;
    }

    private CategoriaDTO transformacionDTO(CategoriaModel category) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setIdCategoria(category.getIdCategoria());
        categoriaDTO.setDescripcion(category.getDescripcion());
        categoriaDTO.setEstado(category.getEstado());
        categoriaDTO.setProductos(category.getProductos());
        return categoriaDTO;
    }
}
