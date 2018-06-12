package business;

import java.util.List;

import dao.DisciplinaDao;
import model.Disciplina;

public class DisciplinaBusiness {

	private DisciplinaDao disciplinaDAO = new DisciplinaDao();

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
	
	public void excluir(Disciplina disciplina) {
		disciplinaDAO.remove(disciplina.getIdDisciplina());
	}

}
