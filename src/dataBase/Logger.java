package dataBase;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Logger {

    public void write(String json) {

        try {
            PrintWriter printWriter = new PrintWriter("dataBaseLog.txt");
            printWriter.write(json);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read() {

        try {
            return Files.readAllLines(Paths.get("dataBaseLog.txt")).stream().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            write(new Gson().toJson(new DataBase()));
            return read();
        }
    }
}
