package comspringtoolsappproyecto.model.dao;






import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import comspringtoolsappproyecto.model.entity.Ventas;

public interface IVentas extends JpaRepository<Ventas, Long>{
	@Query("select count(*) from Ventas")
	public int contarVentas();

	@Query("select v from Ventas v join fetch v.cliente c join fetch v.detalle d join fetch d.producto where v.fecha BETWEEN :desde AND :hasta ")

	public List<Ventas> findByAllVentas(@Param("desde")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date des,@Param("hasta")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date has);
	
	@Query("select sum(v.total) from Ventas v where v.fecha BETWEEN :desde AND :hasta ")
	public  Float calcularSuma(@Param("desde")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date des,@Param("hasta")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date has);
	
	

}
