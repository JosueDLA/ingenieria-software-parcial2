package gt.edu.umg.ingenieria.sistemas.parcial2.inventario.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.inventario.dao.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    public List<ProductoEntity> buscarTodos() {
        return (List<ProductoEntity>) this.productoRepository.buscar();
    }
    
    public ProductoEntity registrarProducto(ProductoEntity p1){
        return this.productoRepository.save(p1);
    }
    
    public ProductoEntity actualizarStock(long id, String opcion, int cantidad){
        ProductoEntity p1 = new ProductoEntity();
        p1 = this.productoRepository.findById(id).get();
        p1.setStock(cantidad);
        
        if(opcion.toLowerCase().equals("incrementar")){
            p1.setStock(p1.getStock() + cantidad);
        }
        else if(opcion.toLowerCase().equals("decrementar")){
            p1.setStock(p1.getStock() - cantidad);
        }
        
        return this.productoRepository.save(p1);
    }
}
