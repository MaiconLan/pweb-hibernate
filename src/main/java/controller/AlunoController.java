package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import business.AlunoBusiness;
import model.Aluno;
import model.Endereco;

@ViewScoped
@ManagedBean(name = "alunoController")
public class AlunoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;

	private List<Aluno> alunos = new ArrayList<>();

	private List<String> ufs = new ArrayList<>();

	private AlunoBusiness alunoBusiness;

	@PostConstruct
	public void initialize() {
		popuplarUfs();
		novoAluno();
	}

	private void popuplarUfs() {
		ufs.add("AC");
		ufs.add("AL");
		ufs.add("AM");
		ufs.add("AP");
		ufs.add("BA");
		ufs.add("CE");
		ufs.add("DF");
		ufs.add("ES");
		ufs.add("GO");
		ufs.add("MA");
		ufs.add("MG");
		ufs.add("MS");
		ufs.add("MT");
		ufs.add("PA");
		ufs.add("PB");
		ufs.add("PE");
		ufs.add("PI");
		ufs.add("PR");
		ufs.add("RJ");
		ufs.add("RN");
		ufs.add("RO");
		ufs.add("RR");
		ufs.add("RS");
		ufs.add("SC");
		ufs.add("SE");
		ufs.add("SP");
		ufs.add("TO");
	}

	public void editar(ActionEvent event) {
		setAluno((Aluno) event.getComponent().getAttributes().get("alunoSelecionado"));
	}

	public void excluir(ActionEvent event) {
		alunos.remove((Aluno) event.getComponent().getAttributes().get("alunoExcluido"));
	}

	public void salvar() {
		if (alunos.contains(aluno)) {
			alunos.remove(aluno);
		}
		alunos.add(aluno);
		novoAluno();
	}

	public void novoAluno() {
		aluno = new Aluno();
		aluno.setEndereco(new Endereco());
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

	public List<String> getUfs() {
		return ufs;
	}

	public void setUfs(List<String> ufs) {
		this.ufs = ufs;
	}

}
