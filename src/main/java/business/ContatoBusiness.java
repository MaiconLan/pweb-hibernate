package business;

import java.util.List;

import dao.ContatoDao;
import model.Contato;

public class ContatoBusiness {

	private ContatoDao contatoDao = new ContatoDao();

	public void salvar(Contato contato) {
		contatoDao.save(contato);
	}

	public List<Contato> listar() {
		try {
			return contatoDao.list();

		} catch (NullPointerException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
