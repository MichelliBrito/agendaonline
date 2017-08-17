package agendaonline.com.repositories;

import org.springframework.data.repository.CrudRepository;

import agendaonline.com.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{

}
