package Dados;

public class Multa {
	
	private String placa;
	private String proprietario;
	private String local;
	private String data;
	private String hora;
		
	public Multa(String placa, String proprietario, String local, String data, String hora) {
		super();
		this.placa = placa;
		this.proprietario = proprietario;
		this.local = local;
		this.data = data;
		this.hora = hora;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

}
