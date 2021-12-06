package comspringtoolsappproyecto.model.sevices;

import comspringtoolsappproyecto.model.entity.Usuarios;

public interface IUsuariosService {
public void singUpUsuario(Usuarios usuarios);
public Usuarios findById(Long id);
}
