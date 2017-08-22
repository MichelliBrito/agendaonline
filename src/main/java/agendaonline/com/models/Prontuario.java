package agendaonline.com.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Prontuario {
	
	@Id
	@DateTimeFormat(pattern="dd-mm-yyyy 00:00:00.000")
	private String data;
	
	@ManyToOne
	private Paciente paciente;//foreing key
	
	@ManyToOne
	private Procedimento procedimento;
	
	private String anamnese;
	private String diagnostico;
	private String procedimentoRealizado;
	private String prescricaoRemedios;
	private String prescricaoExames;
	private String resultados;
	private String observacao;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getAnamnese() {
		return anamnese;
	}
	public void setAnamnese(String anamnese) {
		this.anamnese = anamnese;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getProcedimentoRealizado() {
		return procedimentoRealizado;
	}
	public void setProcedimentoRealizado(String procedimentoRealizado) {
		this.procedimentoRealizado = procedimentoRealizado;
	}
	public String getPrescricaoRemedios() {
		return prescricaoRemedios;
	}
	public void setPrescricaoRemedios(String prescricaoRemedios) {
		this.prescricaoRemedios = prescricaoRemedios;
	}
	public String getPrescricaoExames() {
		return prescricaoExames;
	}
	public void setPrescricaoExames(String prescricaoExames) {
		this.prescricaoExames = prescricaoExames;
	}
	public String getResultados() {
		return resultados;
	}
	public void setResultados(String resultados) {
		this.resultados = resultados;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	
	
	
	
}
