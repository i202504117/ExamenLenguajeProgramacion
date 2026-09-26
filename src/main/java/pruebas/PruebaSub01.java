package pruebas;

import java.util.List;

import dao.SubjectDAO;
import dao.SubjectDAOImplements;
import model.Subject;

public class PruebaSub01 {

	public static void main(String[] args) {
		SubjectDAO subject = new SubjectDAOImplements();
	    List<Subject> lista= subject.listar();
	    for(Subject s:lista) {
	    	System.out.println(s.getIdsubject());
	    	System.out.println(s.getSubject());
	    	System.out.println(s.getCredits());

	    	
	    }


	}

}
