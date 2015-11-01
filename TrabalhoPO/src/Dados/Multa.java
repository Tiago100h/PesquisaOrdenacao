package Dados;

import java.util.Date;

public class Multa {
	
	private String placa;
	private String proprietario;
	private String local;
	private Date dataHora;
		
	public Multa(String placa, String proprietario, String local, Date dataHora) {
		super();
		this.placa = placa;
		this.proprietario = proprietario;
		this.local = local;
		this.dataHora = dataHora;
	}
	
	public Multa() {
		
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

}
