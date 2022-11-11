package ConexionesBBDD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="alumnos")
public class AlumnoITEP implements Serializable {

	@Id
	@Column(name="id")
	int id;
	
	@Column(name="nombre")
	String nombre;
	
	@Column(name="apellido1")
	String apellido1;
	
	@Column(name="apellido2")
	String apellido2;
	
	public AlumnoITEP() {
		
	}
	
	public AlumnoITEP(int id) {
		this.id = id;
	}
	
	public AlumnoITEP(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public AlumnoITEP(int id, String nombre, String apellido1, String apellido2) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
}
