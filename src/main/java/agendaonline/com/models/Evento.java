package agendaonline.com.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	
	private String titulo;
	private String comeco;
	private String fim;
	private long url;
	private String data;
	
	public Evento(){
		
	}
	
	public Evento(Consulta consulta){
		this.titulo = consulta.getPaciente().getNome();
		this.comeco = consulta.getHorarioInicio();
		this.fim = consulta.getHorarioTermino();
		this.url = consulta.getCodigo();
		this.data = consulta.getData();
	}
	
	

	@Override
	public String toString() {
		return "" + url + "";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getComeco() {
		comeco = data + " " + comeco;
		return comeco;
	}

	public void setComeco(String comeco) {
		this.comeco = comeco;
	}

	public String getFim() {
		fim = data + " " + fim;
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public String getUrl() {
		String link = "http://localhost:8080/consulta/";
		String newUrl = link.concat(this.toString());
		return newUrl;
	}

	public void setUrl(long url) {
		this.url = url;
	}

}
