package business;

import java.util.List;

import dao.MatriculaDao;
import model.Matricula;

public class MatriculaBusiness {

	private MatriculaDao matriculaDAO = new MatriculaDao();

	public void salvar(Matricula matricula) {
		matriculaDAO.save(matricula);
	}

	public List<Matricula> listar() {
		try {
			return matriculaDAO.list();

		} catch (NullPointerException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void excluir(Matricula matricula) {
		matriculaDAO.remove(matricula.getIdMatricula());
	}

}
