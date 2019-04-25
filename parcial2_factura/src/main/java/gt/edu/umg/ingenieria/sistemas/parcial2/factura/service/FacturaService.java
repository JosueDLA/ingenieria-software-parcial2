package gt.edu.umg.ingenieria.sistemas.parcial2.factura.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.DetalleFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.CabeceraFacturaRepository;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.DetalleFacturaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private CabeceraFacturaRepository cabeceraFacturaRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    
    @Autowired
    private CabeceraFacturaRepository cabeceraFacturaRepos;
    
    public List<CabeceraFacturaEntity> buscarTodasCabecerasFactura() {
        return (List<CabeceraFacturaEntity>) this.cabeceraFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura() {
        return (List<DetalleFacturaEntity>) this.detalleFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura(Long idCabeceraFactura) {
        return this.detalleFacturaRepository.findByHeader(idCabeceraFactura);
    }
    
    public CabeceraFacturaEntity crearFactura(CabeceraFacturaEntity f1){
        return this.cabeceraFacturaRepos.save(f1);
    }
    
    public DetalleFacturaEntity crearDetalleFactura(DetalleFacturaEntity d1){
        return this.detalleFacturaRepository.save(d1);
    }
    
    
}
