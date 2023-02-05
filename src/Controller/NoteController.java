package Controller;

import Model.Note;
import Model.Repository;
import Model.Note;

import java.util.List;

public class NoteController {
    private final Repository repository;

    public NoteController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) throws Exception {
//        validateNote(note);
        repository.CreateNote(note);
    }

    public Note readNote (String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }

        throw new Exception("User not found");
    }
    public Note readOneNote(String idNumber) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(idNumber)) {
                return note;
            }
        }
        throw new Exception("User not found");
    }

    public List<Note> readList() {
        List<Note> result = repository.getAllNotes();
        return result;
    }

    public void updateNote(String idNumber, Note newNote) throws Exception {
        idPresenceValidation(idNumber);
        newNote.setId(idNumber);
//        validateNoteId(newNote);
        repository.updateNote(newNote);
    }
    public void deleteNote(String idnumber) {

        repository.DeleteNote(idnumber);
    }

//    private void validateNote(Note note) throws Exception {
//        if (note.getHeading().contains(" "))
//            throw new Exception("User name has unacceptable characters");
//    }

//    private void validateNoteId (Note note) throws Exception{
//        if (note.getId().isEmpty())
//            throw new Exception("User has no id");
//        validateNote(note);
//    }

    public void idPresenceValidation (String inputId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note n : notes) {
            if (n.getId().equals(inputId))
               return;
        }
        throw new Exception("No such ID here");
    }
}
