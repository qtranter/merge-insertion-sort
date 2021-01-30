import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class InputGenerator {

    Random random = new Random();

    public InputGenerator() {
        createInputKeys();
    }

    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }

    public void createInputKeys() {
        for(int i = 1; i < 7; i++ ) {
            int inputKey = (int) Math.pow(10, i);
            File file = new File("src/resources/" + inputKey + "keys.txt");
            try {
                if (isFileEmpty(file)) {
                    Writer wr = new FileWriter("src/resources/" + inputKey + "keys.txt");
                    for (int j = 0; j < inputKey; j++) {
                        wr.write(String.valueOf(random.nextInt()));
                        wr.write("\n");
                    }
                    wr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

