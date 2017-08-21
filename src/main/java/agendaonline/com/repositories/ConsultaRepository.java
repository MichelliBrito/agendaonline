package agendaonline.com.repositories;

import org.springframework.data.repository.CrudRepository;

import agendaonline.com.models.Consulta;

public interface ConsultaRepository extends CrudRepository<Consulta, String>{


	Iterable<Consulta> findByData(String data);
	//Iterable<Consulta> findByCodigo(long codigo);
	Consulta findByCodigo(long codigo);
}
