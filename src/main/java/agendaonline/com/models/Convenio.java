package agendaonline.com.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Convenio {

	@Id
	private String nomeConvenio;
	
	@OneToMany //um convenio para muitos pacientes, ou seja, One=convenio toMany=pacientes.
	private List<Paciente> pacientes;

	public String getNomeConvenio() {
		return nomeConvenio;
	}

	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}
	
	
	
}
