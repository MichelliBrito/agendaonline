package agendaonline.com.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Procedimento {

	@Id
	private String tipoProcedimento;
	
	@OneToMany
	private List<Consulta> consultas;

	public String getTipoProcedimento() {
		return tipoProcedimento;
	}

	public void setTipoProcedimento(String tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento;
	}

	
	
	
}
