package com.example.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Empleado;
public interface IEmpleadoDAO extends JpaRepository <Empleado, Integer> {
	//LOS PARÁMETROS DE LA CONSULTA QUE SE DESEEN FILTRAR, SE HAN DE DEFINIR EN LA INTERFAZ DAO
	public List<Empleado> findBySalario(int salario);
}
