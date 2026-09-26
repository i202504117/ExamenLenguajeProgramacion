package dao;
import java.util.List;

import model.Subject;
public interface SubjectDAO {
	
	void registrar(Subject subject);	 
    void editar(Subject subject);
    void eliminar(Integer idsubject);
    public List<Subject> listar();

}
