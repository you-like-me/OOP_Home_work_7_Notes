package Model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private NotesMapper mapper = new NotesMapper();

    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String CreateNote(Note note) {

        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        writeDown(notes);
        return id;
    }
    public void DeleteNote(String idnumber) {
        List<Note> notes = getAllNotes();
        Note target = notes.stream().filter(i -> i.getId().equals(idnumber)).findFirst().get();
        notes.remove(target);
        writeDown(notes);
    }

    @Override
    public void ReadOne(Note note) {
        List<Note> notes = getAllNotes();
        Note target = notes.stream().filter(i -> i.getId().equals(note.getId())).findFirst().get();
        target.getHeading();
        target.getText();
        System.out.println(String.format("Заголовок %d, Текст %d", note.getHeading(), note.getText()));
    }

    @Override
    public void updateNote (Note note) {
        List<Note> notes = getAllNotes();
        Note target = notes.stream().filter(i -> i.getId().equals(note.getId())).findFirst().get();
        target.setHeading(note.getHeading());
        target.setText(note.getText());
        writeDown(notes);
    }

    private void writeDown (List<Note> notes){
        List<String> lines = new ArrayList<>();
        for (Note item: notes) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }
}
