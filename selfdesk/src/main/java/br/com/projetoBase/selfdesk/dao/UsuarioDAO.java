package br.com.projetoBase.selfdesk.dao;

import org.springframework.data.repository.CrudRepository;
import br.com.projetoBase.selfdesk.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	public Usuario findByEmailAndSenha(String email, String senha);
	public Usuario findByRacfAndSenha(String racf, String senha);
	public Usuario findByRacf(String racf);
}