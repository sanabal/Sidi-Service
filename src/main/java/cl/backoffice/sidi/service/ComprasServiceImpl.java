package cl.backoffice.sidi.service;

import cl.backoffice.sidi.dto.CompraDTO;
import cl.backoffice.sidi.model.CompraModel;
import cl.backoffice.sidi.model.ProductoModel;
import cl.backoffice.sidi.repository.CompraRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComprasServiceImpl implements ComprasService, InitializingBean {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public List<CompraDTO> listaCompras() throws Exception {
        List<CompraModel> lista=null;
        List<CompraDTO> listaDTO= new ArrayList<CompraDTO>();
        try{
             lista = compraRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
        for (CompraModel compra:lista){
            listaDTO.add(transformacionDTO(compra));
        }

        return listaDTO;
    }
    @Override
    public CompraDTO detalleCompra(Long id) throws Exception{
        CompraDTO detalleDTO = null;
        try {
            CompraModel compra= compraRepository.getById(id);
            detalleDTO = transformacionDTO(compra);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return detalleDTO;
    }

    private CompraDTO transformacionDTO(CompraModel compra) {
        CompraDTO compraDTO=new CompraDTO();

        compraDTO.setIdCompra(compra.getIdCompra());
        compraDTO.setComentario(compra.getComentario());
        compraDTO.setIdCliente(compra.getCliente().getId());
        compraDTO.setFecha(compra.getFecha());
        compraDTO.setMedioPago(compra.getMedioPago());
        compraDTO.setEstado(compra.getEstado());

        return compraDTO;
    }
}
