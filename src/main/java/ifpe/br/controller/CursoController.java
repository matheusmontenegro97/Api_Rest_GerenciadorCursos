package ifpe.br.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpe.br.repository.CursoRepository;
import ifpe.br.model.Curso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("curso")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<Curso> list(){
		return cursoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Curso retrievalCursoById(@PathVariable Long id) {
		Optional<Curso> option = cursoRepository.findById(id);
		if(option.isEmpty())
			return null;
		return option.get();
	}
	
	@PostMapping
	public String createCurso(@RequestBody Curso curso) {
		if(curso.getNumeroAlunosMatriculados() > curso.getnumeroMaximoAlunos()) {
			return "Não é possível haver mais alunos matriculados que o máximo permitido!";
		}
		if (curso.getDataEncerramentoCurso().isBefore(curso.getDataInicioCurso())) {
			return "Data de encerramento anterior à data de início";
		}
		else {
		cursoRepository.save(curso);
		return "As informações do curso foram salvas.";
		}
	}
	
	@PutMapping
	public String updateCurso(@RequestBody Curso curso) {
		if (curso.getId() == null)
			return "Informe o id do curso!";
		
		cursoRepository.save(curso);
		return "Os dados referente ao curso foram atualizados";
	}
	
	@DeleteMapping
	public String deleteCurso(@RequestBody Curso curso) {
		if (curso.getId() == null)
			return "Informe o id do curso!";
		
		cursoRepository.delete(curso);
		return "O curso foi deletado!";
	}
	
	
	
}
