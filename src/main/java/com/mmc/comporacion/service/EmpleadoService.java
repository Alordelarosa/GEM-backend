package com.mmc.comporacion.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.mmc.comporacion.entity.Empleado;

public interface EmpleadoService {
	Page<Empleado> listarEmpleadoPaginadosYFiltrados(int page, int size, String nombre);
	Empleado registrarEmpleado(Empleado empleado);
	Optional<Empleado> actualizarEmpleado(Empleado empleado, Long id);
	Optional<Empleado> buscarPorId(Long id);
	void eliminarEmpleado(Long id);
	
}
