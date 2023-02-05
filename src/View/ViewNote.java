package View;

import Controller.NoteController;
import Model.Note;

import java.util.List;
import java.util.Scanner;

public class ViewNote {

    private NoteController noteController;

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase());
            if (com == Commands.EXIT) return;
            try {
                switch (com) {
                    case CREATE:
                        String header = prompt("Заголовок записки: ");
                        String text = prompt("Текст записки: ");
                        noteController.saveNote(new Note(header, text));
                        break;
                    case READ:
                        String id = prompt("Идентификатор пользователя: ");
                        Note note = noteController.readNote(id);
                        System.out.println(note);
                        break;
                    case LIST:
                        List<Note> lst = noteController.readList();
                        lst.forEach(i -> System.out.println(i + "\n"));
                        break;
                    case UPDATE:
                        String numId = prompt("Какую записку редактировать? Введите номер ID: ");
                        noteController.idPresenceValidation(numId);
                        noteController.updateNote(numId, createANote());
                        break;
                }
            } catch (Exception e) {
                System.out.println("Oopsie!\n"+ e.getMessage()); ;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private Note createANote() {
        String header = prompt("Заголовок записки: ");
        String text = prompt("Текст записки: ");
        Note newNote = new Note(header, text);
        return newNote;
    }
}
