package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import model.Disciplina;

@ViewScoped
@ManagedBean(name = "disciplinaController")
public class DisciplinaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Disciplina disciplina;

	private List<Disciplina> disciplinas = new ArrayList<>();

	@PostConstruct
	public void initialize() {
		novaDisciplina();
	}

	public void editar(ActionEvent event) {
		setDisciplina((Disciplina) event.getComponent().getAttributes().get("disciplinaSelecionada"));
	}

	public void excluir(ActionEvent event) {
		disciplinas.remove((Disciplina) event.getComponent().getAttributes().get("disciplinaExcluidoa"));
	}

	public void salvar() {
		if (disciplinas.contains(disciplina)) {
			disciplinas.remove(disciplina);
		}
		disciplinas.add(disciplina);
		novaDisciplina();
	}

	public void novaDisciplina() {
		disciplina = new Disciplina();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
