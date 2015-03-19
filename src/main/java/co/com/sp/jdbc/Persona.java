package co.com.sp.jdbc;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = -440711180268487776L;

	private long idPersona;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String email;

	public Persona() {
	}

	public Persona(long idPersona) {
		this.idPersona = idPersona;
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre
				+ ", apePaterno=" + apePaterno + ", apeMaterno=" + apeMaterno
				+ ", email=" + email + "]";
	}
}