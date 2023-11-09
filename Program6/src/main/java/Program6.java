/***
 * Program6.java
 * Monica Ball - CS 2050-001
 * Professor Blanche
 *
 * This program sorts an array of strings or numbers using bubble sort
 * and selection sort, timing how long to sort with each method and outputting
 * the result.
 ***/
import java.io.*;
import java.util.Arrays;

public class Program6 {
    final static double BILLION = 1_000_000_000.0;
    final static int TWENTY_THOUSAND = 20_000;

    public static void main(String[] args) {
        int[] numArray = new int[TWENTY_THOUSAND];                //bubbleSort
        BufferedReader numBR = null;
        String[] txtArray = new String[TWENTY_THOUSAND];         //selectionSort
        BufferedReader txtBR = null;

        try {
            numBR = new BufferedReader(new FileReader("NumbersInFile.txt"));
            txtBR = new BufferedReader(new FileReader("StringsInFile.txt"));

            String s;
            int x;

            for (int i = 0; i < TWENTY_THOUSAND; i++) {
                s = numBR.readLine();
                if (s != null) {
                    numArray[i] = Integer.parseInt(s);
                }

                s = txtBR.readLine();
                txtArray[i] = s;
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not Found. " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        } //end BR try-catch with exceptions
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            if (numBR != null) {
                numBR.close();
            }
            if (txtBR != null) {
                txtBR.close();
            }
        } catch (IOException e) {
            System.err.println("Error while closing BufferReader." + e.getMessage());
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter("results.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {

            // Redirect System.out to write to the file
            System.setOut(new PrintStream(new FileOutputStream("results.txt")));

            // Time to sort integer arrays
            timing(bw, "Integer Bubble Sort: ", () -> bubbleSort(numArray.clone()));
            timing(bw, "Integer Selection Sort: ", () -> selectionSort(numArray.clone()));

            // Time to sort string arrays
            timing(bw, "String Bubble Sort: ", () -> bubbleSort(txtArray.clone()));
            timing(bw, "String Selection Sort: ", () -> selectionSort(txtArray.clone()));

        } catch (IOException e) {
            System.err.println("Error while writing to results.txt: " + e.getMessage());
            e.printStackTrace();
        }
    }//end main method

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } //swap
            }
        }
    }//end int bubbleSort

    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }//end int selectionSort

    public static void bubbleSort(String arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] == null) {
                    if (arr[j +1] != null) {
                        String temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else if (arr[j + 1] == null || arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } //swap
            }
        }
    }//end txt bubbleSort

    public static void selectionSort(String arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] != null && (arr[smallest] == null || arr[j].compareTo(arr[smallest]) < 0)) {
                    smallest = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }//end txt selectionSort

    public static void timeOutput(String sop) {
        System.out.println(sop);
    }

    public static void timing(BufferedWriter bw, String label, Runnable task) {
        double timeStart = System.nanoTime();
        task.run();
        double timeEnd = System.nanoTime();
        double timeDiff = (timeEnd - timeStart) / BILLION;

        // Write the output to the BufferedWriter
        try {
            bw.write(label + ": " + timeDiff + " seconds");
            bw.newLine();
            bw.flush(); // Ensure the data is written immediately
        } catch (IOException e) {
            System.err.println("Error while writing to BufferedWriter: " + e.getMessage());
            e.printStackTrace();
        }
    }
} //end class
