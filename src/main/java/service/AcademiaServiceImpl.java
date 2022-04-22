package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Service
public class AcademiaServiceImpl implements AcademiaService {

	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public void alta(Alumno a) {
//		if (existeAlumno(a) == null) {
//			em.persist(a);
//			return "alta";
//		}
//		return "error";
		em.persist(a);
	}

	@Override
	public List<String> cursos() {
		String jpql = "select distinct(curso) from Alumno a";
		Query query = em.createQuery(jpql);
		List<String> cursos = query.getResultList();
		return cursos;

//		String sql = "select distinct(curso) from alumnos";
//		return template.query(sql, (rs, f)->rs.getString("curso"));
	}

	@Override
	public List<Alumno> buscarPorCurso(String curso) {
		String jpa = "select a from Alumno a where a.curso = ?1";
		Query query = em.createQuery(jpa);
		query.setParameter(1, curso);
		List<Alumno> lista_Alumnos = query.getResultList();
		return lista_Alumnos;
	}

	@Transactional
	@Override
	public boolean existeAlumno(String nombre) {
		String jpa = "select a from Alumno a where a.nombre = :nombre";
		Query query = em.createQuery(jpa);
		query.setParameter("nombre", nombre);
		List<Alumno> lista_Alumnos = query.getResultList();
		return lista_Alumnos.size()>0;
	}

}
