package business;

import java.util.List;

import dao.AlunoDao;
import model.Aluno;

public class AlunoBusiness {

	private AlunoDao alunoDao = new AlunoDao();

	public void salvar(Aluno aluno) {
		if (aluno.getIdAluno() == null) {
			alunoDao.save(aluno);
		} else {
			alunoDao.update(aluno);
		}
	}

	public List<Aluno> listar() {
		return alunoDao.list();
	}
	
	public void excluir(Aluno aluno) {
		alunoDao.remove(aluno.getIdAluno());
	}

}
