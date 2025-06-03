package com.mmc.comporacion.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mmc.comporacion.entity.Empleado;
import com.mmc.comporacion.repository.EmpleadoRepository;
import com.mmc.comporacion.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
    public Page<Empleado> listarEmpleadoPaginadosYFiltrados(int page, int size, String nombre) {
        // Si el nombre no está vacío, filtramos por nombre que comienza con el patrón dado
        if (nombre != null && !nombre.isEmpty()) {
            return empleadoRepository.findByNombreStartingWithIgnoreCase(nombre, PageRequest.of(page, size));
        } else {
            // Si no hay filtro, devolvemos todos los clientes con paginación
            return empleadoRepository.findAll(PageRequest.of(page, size));
        }
    }

	@Override
	public Empleado registrarEmpleado(Empleado empleado) {
		empleado.setFechaRegistro(LocalDateTime.now());
		return empleadoRepository.save(empleado);
	}

	@Override
	public Optional<Empleado> actualizarEmpleado(Empleado empleado, Long id) {
		// Verificamos la existencia de ese empleado
		if (!empleadoRepository.existsById(id)) {
			throw new IllegalArgumentException("El empleado no existe para ser actualizado");
		}

		Optional<Empleado> empleadoEncontrado = empleadoRepository.findById(id);
		return empleadoEncontrado.map(empleadoExistente -> {
			empleadoExistente.setNombre(empleado.getNombre());
			empleadoExistente.setMovil(empleado.getMovil());
			empleadoExistente.setEmail(empleado.getEmail());
			empleadoExistente.setDireccion(empleado.getDireccion());
			empleadoExistente.setFechaRegistro(LocalDateTime.now());
			
			return empleadoRepository.save(empleadoExistente);
		});

	}

	@Override
	public void eliminarEmpleado(Long id) {
		empleadoRepository.deleteById(id);
	}

	@Override
	public Optional<Empleado> buscarPorId(Long id) {
		return empleadoRepository.findById(id);
	}
}
