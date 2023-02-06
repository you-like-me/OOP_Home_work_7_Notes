package Model;

import java.util.List;

public class RepositoryDecorator implements Repository{

    Repository rep;
    Logable log;

    public RepositoryDecorator(Repository repository, Logable logable) {
        this.rep = repository;
        this.log = logable;
    }

    @Override
    public List<Note> getAllNotes() {
        log.WriteLog("получены все записки");
        List<Note> notes = rep.getAllNotes();
        return notes;
    }

    @Override
    public String CreateNote(Note note) {
        log.WriteLog("добавлена записка");
        String id = rep.CreateNote(new Note(note.getHeading(), note.getText()));
        return id;
    }

    @Override
    public void updateNote(Note note) {
        log.WriteLog("изменена записка");
        rep.updateNote(note);
    }

    @Override
    public void DeleteNote(String idnumb) {
        log.WriteLog("удалена записка");
        rep.DeleteNote(idnumb);
    }

    @Override
    public void ReadOne(Note note) {
        log.WriteLog("прочитана одна записка");
        rep.ReadOne(note);
    }
}
