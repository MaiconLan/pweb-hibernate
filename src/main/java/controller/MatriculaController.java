package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import business.AlunoBusiness;
import business.DisciplinaBusiness;
import business.MatriculaBusiness;
import model.Aluno;
import model.Disciplina;
import model.Matricula;

@ViewScoped
@ManagedBean(name = "matriculaController")
public class MatriculaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Aluno> alunos = new ArrayList<>();

	private List<Disciplina> disciplinas = new ArrayList<>();

	private List<Matricula> matriculas = new ArrayList<>();

	private Matricula matricula;

	private AlunoBusiness alunoBusiness = new AlunoBusiness();

	private MatriculaBusiness matriculaBusiness = new MatriculaBusiness();

	private DisciplinaBusiness disciplinaBusiness = new DisciplinaBusiness();
	
	@PostConstruct
	public void initialize() {
		novaMatricula();
		listarAlunos();
		listarContatos();
	}

	public void selecionarDisciplina(Disciplina disciplina) {
		matricula.setDisciplina(disciplina);
	}
	
	public void selecionarAluno(Disciplina disciplina) {
		matricula.setDisciplina(disciplina);
	}
	
	public void excluir(ActionEvent event) {
		Matricula matricula = (Matricula) event.getComponent().getAttributes().get("matriculaExcluida");
		matriculaBusiness.excluir(matricula);
		listarMatriculas();
	}

	public void salvar() {
		matriculaBusiness.salvar(matricula);
		listarMatriculas();
		novaMatricula();
	}

	public void listarMatriculas() {
		matriculas = matriculaBusiness.listar();
	}

	public void listarAlunos() {
		alunos = alunoBusiness.listar();
	}

	public void listarContatos() {
		disciplinas = disciplinaBusiness.listar();
	}

	public void novaMatricula() {
		matricula = new Matricula();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

}
