package service;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Alumno;

@Repository
public interface AcademiaService {

	void alta(Alumno a);
	
	List<String> cursos();
	
	List<Alumno> buscarPorCurso(String curso);

	boolean existeAlumno(String nombre);
}
