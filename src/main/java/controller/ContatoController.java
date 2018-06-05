package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import business.ContatoBusiness;
import model.Contato;

@ViewScoped
@ManagedBean(name = "contatoController")
public class ContatoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Contato contato;

	private ContatoBusiness contatoBusiness = new ContatoBusiness();

	private List<Contato> contatos = new ArrayList<>();

	private List<String> ufs = new ArrayList<>();

	@PostConstruct
	public void initialize() {
		novaContato();
		recarregarContatos();
		popuplarUfs();
	}

	public void editar(ActionEvent event) {
		setContato((Contato) event.getComponent().getAttributes().get("contatoSelecionado"));
	}

	public void excluir(ActionEvent event) {
		contatos.remove((Contato) event.getComponent().getAttributes().get("contatoExcluido"));
		recarregarContatos();
	}

	public void salvar() {
		contatoBusiness.salvar(contato);
		novaContato();
		recarregarContatos();
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

	public void recarregarContatos() {
		contatos = contatoBusiness.listar();
	}

	public void novaContato() {
		contato = new Contato();
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<String> getUfs() {
		return ufs;
	}

	public void setUfs(List<String> ufs) {
		this.ufs = ufs;
	}

}
