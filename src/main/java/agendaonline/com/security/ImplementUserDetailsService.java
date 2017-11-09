package agendaonline.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import agendaonline.com.models.Usuario;
import agendaonline.com.repositories.UsuarioRepository;

@Repository
public class ImplementUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Usuario usuario = ur.findByNome(nome);
		
	    if (usuario == null) {
	      throw new UsernameNotFoundException("Usuário não encontrado!");
	    }
		return usuario;
	}

}
