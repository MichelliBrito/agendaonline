package agendaonline.com.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import agendaonline.com.models.Role;
import agendaonline.com.models.Usuario;
import agendaonline.com.repositories.UsuarioRepository;

@Transactional
@Repository
public class ImplementUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Usuario usuario = ur.findByNome(nome);

		System.out.println(usuario.getAuthorities());
		
	    if (usuario == null) {
	      throw new UsernameNotFoundException("Usuário não encontrado!");
	    }
		return new org.springframework.security.core.userdetails.User(
		          usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, 
		          true, usuario.getAuthorities());
	}

}
