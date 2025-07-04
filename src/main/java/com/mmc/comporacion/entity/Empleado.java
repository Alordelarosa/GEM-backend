package com.mmc.comporacion.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor 
@AllArgsConstructor
@Table(name = "empleado")
public class Empleado {
	@Id  
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	 @Column(nullable = false, length = 100)
	private String nombre;
	 @Column(length = 20) 
	private String movil;
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	@Column(length = 255)
	private String direccion;
	@Column(name = "fecha_registro", updatable = false)
	private LocalDateTime fechaRegistro;
}
