package com.mmc.comporacion.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mmc.comporacion.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	Page<Empleado> findByNombreStartingWithIgnoreCase(String nombre, Pageable pageable);
}
