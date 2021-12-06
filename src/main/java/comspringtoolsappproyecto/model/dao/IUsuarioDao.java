package comspringtoolsappproyecto.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import comspringtoolsappproyecto.model.entity.Usuarios;

public interface IUsuarioDao extends JpaRepository<Usuarios, Long>{
	
}
