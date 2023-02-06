package Model;

public class FileLogger implements Logable{

    @Override
    public void WriteLog(String message) {
        System.out.println(message);
    }
}
