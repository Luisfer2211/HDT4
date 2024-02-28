import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class convertidor {
    public String readAndRemoveSpaces(String filePath) {
        StringBuilder contentWithoutSpaces = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentWithoutSpaces.append(line.replaceAll("\\s", ""));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return contentWithoutSpaces.toString();
    }

}
