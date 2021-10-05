package ifpe.br.model;


import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	
	private String nome;
	private int numeroMaximoAlunos;
	private int numeroAlunosMatriculados;
	private LocalDate dataInicioCurso;
	private LocalDate dataEncerramentoCurso;
	private String resumo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getnumeroMaximoAlunos() {
		return numeroMaximoAlunos;
	}

	public void setnumeroMaximoAlunos(int maxAlunos) {
		this.numeroMaximoAlunos = maxAlunos;
	}

	public int getNumeroAlunosMatriculados() {
		return numeroAlunosMatriculados;
	}

	public void setNumeroAlunosMatriculados(int numAlunosMatriculados) {
		this.numeroAlunosMatriculados = numAlunosMatriculados;
	}

	public LocalDate getDataInicioCurso() {
		return dataInicioCurso;
	}

	public void setDataInicioCurso(LocalDate dataInicio) {
		this.dataInicioCurso = dataInicio;
	}

	public LocalDate getDataEncerramentoCurso() {
		return dataEncerramentoCurso;
	}

	public void setDataEncerramentoCurso(LocalDate dataEncerramento) {
		this.dataEncerramentoCurso = dataEncerramento;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

}
