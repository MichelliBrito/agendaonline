package agendaonline.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import agendaonline.com.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	Usuario findByNome(String nome);
}
