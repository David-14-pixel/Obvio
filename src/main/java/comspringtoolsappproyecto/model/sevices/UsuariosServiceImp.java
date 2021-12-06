package comspringtoolsappproyecto.model.sevices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comspringtoolsappproyecto.model.dao.IRolesDao;
import comspringtoolsappproyecto.model.dao.IUsuarioDao;
import comspringtoolsappproyecto.model.entity.Roles;
import comspringtoolsappproyecto.model.entity.Usuarios;
@Service
public class UsuariosServiceImp implements IUsuariosService{
	@Autowired
	private IRolesDao irolesdao;
	@Autowired
	private IUsuarioDao iusudao;
	@Override
	@Transactional
	public void singUpUsuario(Usuarios usuarios) {
		Roles  roles = irolesdao.findByNombre("CLIENTE");
		Set<Roles> listroles = new HashSet<>(Arrays.asList(roles));
		usuarios.setEnable(true);
		usuarios.setRoles(listroles);
		iusudao.save(usuarios);
		
		
	}
	@Override
	public Usuarios findById(Long id) {
		// TODO Auto-generated method stub
		return iusudao.findById(id).orElse(null);
	}

}
