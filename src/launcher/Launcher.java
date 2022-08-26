package launcher;
import entities.Student;
import gui.SimplePresentationScreen;
public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen s = new SimplePresentationScreen(
            			new Student(137362,
            					"Dreizzen",
            					"Leonardo",
            					"leodreizzen@gmail.com",
            					"https://github.com/leodreizzen",
            					"/images/fotoPerfil.jpg"));
            	s.setVisible(true);
           }
        });
	}
}
