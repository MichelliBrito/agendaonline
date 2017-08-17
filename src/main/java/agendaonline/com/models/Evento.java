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
	
	private String title;
	private String start;
	private String end;
	private String url;
	private String data;
	
	public Evento(){
		
	}
	
	public Evento(Consulta consulta){
		this.title = consulta.getPaciente().getNome();
		this.start = consulta.getHorarioInicio();
		this.end = consulta.getHorarioTermino();
		//this.url = consulta.getCodigo();
		this.data = consulta.getData();
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
		String url = "http://localhost:8080/";
		System.out.println("http://localhost:8080/");
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
