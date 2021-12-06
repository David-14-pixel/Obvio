package comspringtoolsappproyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import comspringtoolsappproyecto.model.entity.Usuarios;
import comspringtoolsappproyecto.model.sevices.IUsuariosService;

@Controller
public class UsuariosController {
	@Autowired
	private IUsuariosService iususer;
	@GetMapping("/formularioregistro")
public String formularioregistro(Model model) {
	model.addAttribute("usuario", new Usuarios());
return "usuarios/formularioregistro";	
}
@PostMapping("/registrousuario")
public String guardarusuario(@ModelAttribute("usuario") Usuarios usuarios, Model  model) {
	iususer.singUpUsuario(usuarios);
	return "redirect:/formulariocliente/"+usuarios.getId();
}
}
