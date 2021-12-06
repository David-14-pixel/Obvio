package comspringtoolsappproyecto.model.sevices;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import comspringtoolsappproyecto.model.entity.Ventas;

public interface IVentasService {
public void GuardarVenta(Ventas ventas);
public List<Ventas> ListarVentas();
public Page<Ventas> ListarPaginado(Pageable pageable);
public int contarVentas();
public Ventas BuscarVentas(Long id);
public List<Ventas> findByAllData(Date des,Date has) ;

public Float calcularTotal(Date des,Date has);
}
