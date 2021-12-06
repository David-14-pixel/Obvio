package comspringtoolsappproyecto.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import comspringtoolsappproyecto.model.entity.Roles;

public interface IRolesDao extends JpaRepository<Roles, Long>{
public Roles findByNombre(String nombre);
}
