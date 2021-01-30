import java.io.*;
import java.util.Scanner;

public class MergeSort {

    int inputKey;
    File file;
    int[] beforeArray;
    Scanner inputFile;
    int index = 0;

    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }

    public MergeSort()  {
        InputGenerator inputGenerator = new InputGenerator();
    }

    public static void main(String[] args) throws FileNotFoundException {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortOutput();
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

            File file = new File("src/resources/output_mergeSort" + inputKey + "keys.txt");
            try {
                if(isFileEmpty(file)) {
                    Writer wr = new FileWriter("src/resources/output_mergeSort" + inputKey + "keys.txt");
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

    private int[] numbers;
    private int[] helper;
    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergeSort(0, number - 1);
    }

    public void mergeSort( int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }
    private void merge(int low, int middle, int high) {

        if (high + 1 - low >= 0) System.arraycopy(numbers, low, helper, low, high + 1 - low);

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }
}
