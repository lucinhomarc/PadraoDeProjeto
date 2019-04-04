package agenda;
import java.util.*;
public class Agenda {
	
	int idagenda;
	public int getIdagenda() {
		return idagenda;
	}
	public void setIdagenda(int idagenda) {
		this.idagenda = idagenda;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdmedico() {
		return idmedico;
	}
	public void setIdmedico(int idmedico) {
		this.idmedico = idmedico;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	int idcliente;
	int idmedico;
	Date data;
	String turno;

}
