package ifpe.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifpe.br.model.Curso;


public interface CursoRepository extends JpaRepository<Curso, Long>{

}
