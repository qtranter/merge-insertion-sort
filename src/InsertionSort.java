import java.io.*;
import java.util.Scanner;

public class InsertionSort {

    int inputKey;
    File file;
    int[] beforeArray;
    Scanner inputFile;
    int index = 0;

    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }

    public InsertionSort()  {
        InputGenerator inputGenerator = new InputGenerator();
    }

    public void sortOutput() throws FileNotFoundException {
        for(int i = 1; i < 7; i ++ ) {
            inputKey = (int) Math.pow(10, i);
            file = new File("src/resources/" + inputKey + "keys.txt");
            inputFile = new Scanner(file);
            beforeArray = new int[inputKey];
            while (inputFile.hasNextInt() && index < beforeArray.length) {
                beforeArray[index] = inputFile.nextInt();
                index++;
            }
            sort(beforeArray);

            File file = new File("src/resources/output_insertionSort" + inputKey + "keys.txt");
            try {
                if(isFileEmpty(file)) {
                    Writer wr = new FileWriter("src/resources/output_insertionSort" + inputKey + "keys.txt");
                    for(int j = 0; j < inputKey; j++) {
                        wr.write(String.valueOf(beforeArray[j]));
                        wr.write("\n");
                    }
                    wr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sortOutput();
    }

    public void sort(int array[]) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
