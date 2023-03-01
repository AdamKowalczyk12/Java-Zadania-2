
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void main(String[] args) {

        char[][] data = {{'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}};

        try {
            FileWriter writer = new FileWriter("data.txt");
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    writer.write(data[i][j]);
                    if (j < data[i].length - 1) {
                        writer.write(" ");
                    }
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}