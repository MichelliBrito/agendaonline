package agendaonline.com.repositories;

import org.springframework.data.repository.CrudRepository;

import agendaonline.com.models.Paciente;
import agendaonline.com.models.Prontuario;

public interface ProntuariosRepository extends CrudRepository<Prontuario, String>{
	Iterable<Prontuario> findByPaciente(Paciente paciente); 
	Prontuario findByData(String data);
}
