package br.com.projetoBase.selfdesk.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoBase.selfdesk.dao.UsuarioDAO;
import br.com.projetoBase.selfdesk.model.Usuario;

@CrossOrigin("*")
@RestController  // indica que atende requisicoes HTTP
public class UsuarioController {
   
	// Aqui temos um exemplo de Injecao de Dependencia
	// na pratica basta apenas declararmos a referencia da interface
	// a anotacao @Autowired delega ao SpringBoot instanciar um objeto que faca isso
	@Autowired
	private UsuarioDAO dao;
	
	// aqui temos um metodo chamado getAllUsers
	// ele eh acessivel atraves da url (http://servidor:porta/usuarios)
	// como eh para consulta, ele retorna uma lista
	// porem usamos o ResponseEntity para que a gente manipule tb o cabecalho HTTP
	@GetMapping("/usuarios")
	public ResponseEntity<ArrayList<Usuario>> getAllUsers(){
		ArrayList<Usuario> lista = (ArrayList<Usuario>)dao.findAll();
		return ResponseEntity.ok(lista);
	}
	
	// e se eu quisesse buscar dados de um unico usuario especifico
	// atraves do seu ID????
	// solucao = GET parametrizado
	// como parametrizar? 2 passos
	// 1 - definir o template de url com {var}
	// 2 - parametrizar o metodo com @PathVariable
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUserById(@PathVariable int id){
		Usuario encontrei = dao.findById(id).orElse(null);
		if (encontrei == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(encontrei);
		}
	}
	
	// agora preciso do meu metodo de LOGIN (aeeeeee)
	@PostMapping("/login/email")
	public ResponseEntity<Usuario> login(@RequestBody Usuario userDoForm){
		Usuario logado = dao.findByEmailAndSenha(userDoForm.getEmail(), userDoForm.getSenha());
		if (logado == null) {
			return ResponseEntity.status(403).build();
		}
		else {
			logado.setSenha(""); // simulando seguranca
			return ResponseEntity.ok(logado);
		}
	}
	
	@PostMapping("/login/racf")
	public ResponseEntity<Usuario> loginPorRacf(@RequestBody Usuario userDoForm) {
		Usuario logado = dao.findByRacfAndSenha(userDoForm.getRacf(), userDoForm.getSenha());
		if (logado == null) {
			return ResponseEntity.status(403).build();
		}
		else {
			logado.setSenha(""); // simulando seguranca
			return ResponseEntity.ok(logado);
		}
	}
	
	@PostMapping("/racfg")
	public ResponseEntity<Usuario> loginPorRacfG(@RequestBody Usuario userDoForm) {
		Usuario logado = dao.findByRacf(userDoForm.getRacf());
		if (logado == null) {
			return ResponseEntity.status(403).build();
		}
		else {
			logado.setSenha(""); // simulando seguranca
			return ResponseEntity.ok(logado);
		}
	}
}