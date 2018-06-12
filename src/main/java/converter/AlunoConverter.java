package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Aluno;

@FacesConverter(value = "alunoConverter", forClass = Aluno.class)
public class AlunoConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Aluno) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof Aluno) {
			Aluno aluno = (Aluno) value;
			if (aluno != null && aluno instanceof Aluno && aluno.getIdAluno() != null) {
				uiComponent.getAttributes().put(aluno.getIdAluno().toString(), aluno);
				return aluno.getIdAluno().toString();
			}
		}
		return "";
	}
}
