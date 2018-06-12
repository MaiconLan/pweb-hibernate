package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Disciplina;

@FacesConverter(value = "disciplinaConverter", forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Disciplina) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof Disciplina) {
			Disciplina disciplina = (Disciplina) value;
			if (disciplina != null && disciplina instanceof Disciplina && disciplina.getIdDisciplina() != null) {
				uiComponent.getAttributes().put(disciplina.getIdDisciplina().toString(), disciplina);
				return disciplina.getIdDisciplina().toString();
			}
		}
		return "";
	}
}
