package agendaonline.com.models;

import java.io.Serializable;

import javax.persistence.Column;
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
	
	private String title;
	
	@Column(name = "comeco")
	private String start;
	
	@Column(name = "fim")
	private String end;
	
	private long url;
	
	private String data;
	
	public Evento(){
		
	}
	
	public Evento(Consulta consulta){
		this.title = consulta.getPaciente().getNome();
		this.start = consulta.getHorarioInicio();
		this.end = consulta.getHorarioTermino();
		this.url = consulta.getCodigo();
		this.data = consulta.getData();
	}
	
	

	@Override
	public String toString() {
		return "" + url + "";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		start = data + " " + start;
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		end = data + " " + end;
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getUrl() {
		//String link = "http://localhost:8080/consulta/";
		String link = "https://appagendaonline.herokuapp.com/consulta";
		String newUrl = link.concat(this.toString());
		return newUrl;
	}

	public void setUrl(long url) {
		this.url = url;
	}

}
