package comspringtoolsappproyecto.model.sevices;




import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import comspringtoolsappproyecto.model.dao.IVentas;
import comspringtoolsappproyecto.model.entity.Ventas;
@Service
public class VentasServiceImp implements IVentasService{
	@Autowired
	private IVentas ventadao;

	@Transactional
	@Override
	public void GuardarVenta(Ventas ventas) {
		ventadao.save(ventas);
		
		
	}

	@Transactional(readOnly=true)
	@Override
	public List<Ventas> ListarVentas() {
		// TODO Auto-generated method stub
		return (List<Ventas>) ventadao.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public int contarVentas() {
		// TODO Auto-generated method stub
		return ventadao.contarVentas();
	}

	@Override
	public Page<Ventas> ListarPaginado(Pageable pageable) {
		// TODO Auto-generated method stub
		return ventadao.findAll(pageable);
	}

	@Transactional(readOnly=true)
	@Override
	public Ventas BuscarVentas(Long id) {
		// TODO Auto-generated method stub
		return ventadao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ventas> findByAllData(Date des, Date has)  {
		
	    System.out.println("desde = "+des+" hastaa = "+has);
	     List<Ventas> vs =  ventadao.findByAllVentas(des, has);   
		return vs;
	}

	@Override
	public Float calcularTotal(Date des, Date has) {
		
		return ventadao.calcularSuma(des, has);
	}

	

}
