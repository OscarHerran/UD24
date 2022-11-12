package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   //JAVA PERSISTANCE, IMPERATIVO PARA MAPPEAR LA CLASE
@Table(name = "EMPLEADO")
public class Empleado {
	
	@Id//TODOS LOS DECORADORES CORRESPONDEN A JAVAX PERSISTANCE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//MAPPEO DE PERSISTANCE DE UN AUTO-INCREMENTAL
	private int id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "salario")
	private int salario;
	
	// POR DEFECTO, SE DEBE DE DECLARAR OBLIGATORIAMENTE
	public Empleado() {
		
	}

	// EL CONSTRUCTOR Y LOS MÉTODOS DE ACCESO SE DECLARAN EN AUTOMÁTICO 
	public Empleado(int id, String name, String apellido, String dni, String cargo, int salario) {
		super();
		this.id = id;
		this.name = name;
		this.apellido = apellido;
		this.dni = dni;
		this.cargo = cargo;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCargo() {
		return cargo;
	}
	
	public int getSalario() {
		return salario;
	}

	public void setCargo(String cargo) {
		if(cargo.equalsIgnoreCase("junior") || cargo.equalsIgnoreCase("senior") || cargo.equalsIgnoreCase("manager") || cargo.equalsIgnoreCase("directivo")) {
			this.cargo = cargo; // SETEAMOS EL CARGO CON EL ENUM PARA ASIGNAR EL SALRIO DE ACUERDO A ELLAS
		}else {
			this.cargo = "becario"; //CASO CONTRARIO ES BECARIO
		}
		
		setSalario();
	}
	
	// SETTEAMOS EL SALARIO RESPECTO A CARGO
	public void setSalario() {
		switch(cargo) {
			case "junior":
				this.salario = 1200;
				break;
			case "manager":
				this.salario = 2800;
				break;
			case "directivo":
				this.salario = 3500;
				break;
			case "senior":
				this.salario = 2400;
				break;
			default:
				this.salario = 350;
				break;
		}
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", name=" + name + ", apellido=" + apellido + ", dni=" + dni + ", cargo=" + cargo
				+ ", salario=" + salario + "]";
	}
}
