package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import business.AlunoBusiness;
import business.ContatoBusiness;
import model.Aluno;
import model.Contato;

@ViewScoped
@ManagedBean(name = "alunoController")
public class AlunoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;

	private List<Aluno> alunos = new ArrayList<>();

	private List<Contato> contatos = new ArrayList<>();

	private AlunoBusiness alunoBusiness = new AlunoBusiness();

	private ContatoBusiness contatoBusiness = new ContatoBusiness();

	@PostConstruct
	public void initialize() {
		novoAluno();
		listarAlunos();
		listarContatos();
	}

	public void editar(ActionEvent event) {
		setAluno((Aluno) event.getComponent().getAttributes().get("alunoSelecionado"));
	}

	public void selecionarContato(ActionEvent event) {
		aluno.setContato((Contato) event.getComponent().getAttributes().get("contatoSelecionado"));
	}

	public void excluir(ActionEvent event) {
		Aluno aluno = (Aluno) event.getComponent().getAttributes().get("alunoExcluido");
		alunoBusiness.excluir(aluno);
		listarAlunos();
	}

	public void salvar() {
		alunoBusiness.salvar(aluno);
		listarAlunos();
		novoAluno();
	}

	public void listarAlunos() {
		alunos = alunoBusiness.listar();
	}

	public void listarContatos() {
		contatos = contatoBusiness.listar();
	}

	public void novoAluno() {
		aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}
