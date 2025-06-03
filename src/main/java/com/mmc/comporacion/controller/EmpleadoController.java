package com.mmc.comporacion.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmc.comporacion.entity.Empleado;
import com.mmc.comporacion.service.EmpleadoService;
import com.mmc.comporacion.util.AppSettings;

@Controller
@RequestMapping("/empleado")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/listar")
    @ResponseBody
    public ResponseEntity<Page<Empleado>> listaEmpleados(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "5") int size,
        @RequestParam(value = "nombre", required = false) String nombre) {

        // Llamamos al servicio para obtener la página de empleados paginados y filtrados
        Page<Empleado> empleados = empleadoService.listarEmpleadoPaginadosYFiltrados(page, size, nombre);
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
	
	
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public ResponseEntity<?> eliminarEmpleado(@PathVariable Long id){
		if(empleadoService.buscarPorId(id).isPresent()) {
			empleadoService.eliminarEmpleado(id);
			return ResponseEntity.ok("Empleado eliminado correctamente");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El empleado no existe");
		}
		
	} 
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<Empleado> registrarEmpleado(@RequestBody Empleado empleado) {
	    Empleado nuevoEmpleado = empleadoService.registrarEmpleado(empleado);
	    return ResponseEntity.ok(nuevoEmpleado);
	}
	
	@PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        Optional<Empleado> empleadoActualizado = empleadoService.actualizarEmpleado(empleado, id);
        return empleadoActualizado.isPresent()
            ? ResponseEntity.ok(empleadoActualizado.get())
            : ResponseEntity.notFound().build();
    }
} 
