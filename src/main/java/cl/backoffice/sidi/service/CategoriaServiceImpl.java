package cl.backoffice.sidi.service;

import cl.backoffice.sidi.dto.CategoriaDTO;
import cl.backoffice.sidi.model.CategoriaModel;
import cl.backoffice.sidi.repository.CategoriaRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements  CategoriaService, InitializingBean {

   @Autowired
   private CategoriaRepository categoriaRepository;


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public List<CategoriaDTO> listaCategorias() {
        List<CategoriaDTO> listaDTO= new ArrayList<CategoriaDTO>();

        List<CategoriaModel> listar = categoriaRepository.findAll();


        for (CategoriaModel category:listar){

                listaDTO.add(transformacionLista(category));
        }
        return listaDTO;
    }

    private CategoriaDTO transformacionLista(CategoriaModel category) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setIdCategoria(category.getIdCategoria());
        categoriaDTO.setDescripcion(category.getDescripcion());
        categoriaDTO.setEstado(category.getEstado());
        categoriaDTO.setProductos(category.getProductos());
        return categoriaDTO;
    }
}
