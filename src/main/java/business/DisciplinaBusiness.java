package business;

import java.util.List;

import dao.DisciplinaDAO;
import model.Disciplina;

public class DisciplinaBusiness {

	private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

	public void salvar(Disciplina disciplina) {
		disciplinaDAO.save(disciplina);
	}

	public List<Disciplina> listar() {
		try {
			return disciplinaDAO.list();

		} catch (NullPointerException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
