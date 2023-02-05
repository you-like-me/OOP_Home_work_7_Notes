import Controller.NoteController;
import Model.FileOperation;
import Model.FileOperationImpl;
import Model.Repository;
import Model.RepositoryFile;
import View.ViewNote;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("notes.txt");
        Repository repository = new RepositoryFile(fileOperation);
        NoteController controller = new NoteController(repository);
        ViewNote view = new ViewNote(controller);
        view.run();
    }
}