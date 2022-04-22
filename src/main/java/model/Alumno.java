package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlumno;
	@Column(name = "nombre", unique = true)
	private String nombre;
	@Column(name = "curso")
	private String curso;
	@Column(name = "nota")
	private double nota;

	public Alumno(String curso) {
		this.curso = curso;
	}
}
