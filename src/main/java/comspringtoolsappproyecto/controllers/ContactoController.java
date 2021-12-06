package comspringtoolsappproyecto.controllers;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {
	@Autowired
	private JavaMailSender mailsender;
	
@GetMapping("/contacto")
public String MostrarFormulario() {
	
return "contacto";
}
@PostMapping("/contacto/enviar")
public String enviarContacto(HttpServletRequest request, Model model) throws MessagingException, IOException {
	String correo = request.getParameter("correo");
	String asutno = request.getParameter("asunto");
	String mensaje = request.getParameter("mensaje");
	MimeMessage mailMessage = mailsender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
	
	String asunto = asutno;
	String contenido = "<center><p style=\"font-size:30px;\"><b>Correo: </b>"+correo+ "</p></center>";
	contenido+="<center><p style=\"font-size:40px;\"><b style=\"color:green;\">Mensaje: </b> "+mensaje+"</p></center>";
	contenido+="<hr><img src='cid:logo'/>";
	helper.setSubject(asunto);
	helper.setText(contenido, true);
	helper.setTo("dh2179555@gmail.com");
	ClassPathResource imagen = new ClassPathResource("/stactic/imagen/correo.png");
	helper.addInline("logo", imagen);
	mailsender.send(mailMessage);
	
	
	return "mensaje";
}

}
