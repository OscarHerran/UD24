package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.EmpleadoServices;
import com.example.demo.dto.Empleado;

@RestController
@RequestMapping("/api") // APUNTAMOS A LA DIRECCION POSTMAN A LA QUE BUSCARA DENTRO DE UN STRING
public class EmpleadoController {

	//CREAMOS UNA INSTANCIA DE LA CLASE SERVICE PARA HACER LLAMADO DE SUS MÉTODOS
	@Autowired
	EmpleadoServices empleadoSERVICE;
	
	@GetMapping("/empleados")
	public List<Empleado> totalEmpleados(){
		return empleadoSERVICE.totalEmpleados();
	}
	
	//CONSULTA API localhost:8181/api/piezas/2
	@GetMapping("/empleados/salario/{salario}")
	public List<Empleado> buscarEmpleado(@PathVariable(name="salario") int salario){ //SERIARIZAMOS EL PARÁMETRO PARA QUE LA API RECONOZCA EL VALOR CPN PATH
		return empleadoSERVICE.buscarEmpleado(salario);
	}
	
	// ¡¡¡ ES IMPERATIVO EL DECODADOR DEL @REQUESTBODY PUES EN CASO CONTRARIO RETORNA ERROR !!!!
	@PostMapping("/empleado")
	public Empleado guardaEmpleado(@RequestBody Empleado emple) {
		return empleadoSERVICE.guardaEmpleado(emple);	
	}
	
	@DeleteMapping("/empleado/{id}")
	public void eliminaEmpleado(@PathVariable(name = "id") int id) {
		empleadoSERVICE.eliminaEmpleado(id);
	}
	
	@GetMapping("empleado/{id}")
	public Empleado ubicaPorID(@PathVariable(name = "id") int id) {
		Empleado empleado = new Empleado();// creamos una instancia de la clase empleado a la que adjudicaremos el valor del método empleadoporID de la clase services
		empleado = empleadoSERVICE.ubicaPorID(id);
		
		System.out.println("Empleado " + empleado);//ES OPCIONAL
		
		return empleado;
	}
	
	@PutMapping("/empleados/{id}")
	public Empleado actualizaEmpleado(@PathVariable(name = "id") int id, @RequestBody Empleado emple) { //EL MÉTODO ACTUALIZAR SIEMPRE RECIBIRÁ AL MENOS 2 PARÁMETROS, EL QUE SE LE INDICARÁ COMO CONDICIONA A ACTUALIZAR Y LA ENTIDAD CON EL @REQUESTBODY PARA SEÑALIZAR SU CONSTRUCCION EN EL MAPPEO
		Empleado empleSEL = new Empleado();
		Empleado empleACTUAL = new Empleado();
		
		empleSEL = empleadoSERVICE.ubicaPorID(id); //EL OBJETO empleSEL recibe le valor del "ubicarporID" de services para ubicar la instancia específica
		
		empleSEL.setName(emple.getName()); // SETTEA LOS VALORES CON EL PARÁMETRO DE LA ENTIDAD ENVIADA COMO PARÁMETRO Y OBTENIENDO CADA UNO DE SUS ATRIBUTOS
		empleSEL.setApellido(emple.getApellido());
		empleSEL.setDni(emple.getDni());
		empleSEL.setCargo(emple.getCargo());
		empleSEL.setSalario();//SALARIO NO SE SETTEA YA QUE SE ESTABLECE SEGÚN EL CARGO
		
		empleACTUAL = empleadoSERVICE.actualizaEmpleado(empleSEL);//HACEMOS USO DEL MÉTODDO ACTUALIZAR Y LE ENVIAMOS POR PARÁMETRO EL EMPLEADO SELECCIONADO PARA QUE EJECUTE E INDIQUE EL VALOR AL EMPLEADOACTUALIZADO
	
		return empleACTUAL;
	}
	
	
}
