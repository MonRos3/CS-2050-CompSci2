/***
 * Program8.java
 * Monica Ball - CS 2050-001
 * Professor Blanche
 *
 * This program creates a Binary Search Tree [BST] out of the text Dracula.
 ***/
import java.io.*;
public class Program8 {

    public static void main(String[] args) throws IOException {
    BinarySearchTree tree = new BinarySearchTree();

        try(BufferedReader br = new BufferedReader(new FileReader("dracula.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[\\s\\n]+");
                for (String word : words) {
                    tree.insert(word);
                }
            }
            } catch (IOException e){
                e.printStackTrace();
            }

        System.out.println("Words in order: ");
        tree.order();

        int nodesNum = tree.countNodes();
        int heightNum = tree.getHeight();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("analysis.txt"))){
            bw.write("Number of nodes: " + nodesNum);
            bw.newLine();
            bw.write("Tree height: " + heightNum);
            bw.newLine();
            int maxNodes = (int) Math.pow(2, heightNum) - 1;
            bw.write("Maximum nodes possible: " + maxNodes);
        }


    } //end main

}
