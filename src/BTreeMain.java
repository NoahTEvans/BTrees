
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import stopwatch.StopWatch;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author justinsnider & NoahEvans
 */
public class BTreeMain
{

    public static void main(String[] args)
    {
        
        BTree<String> tree = new BTree<>();

        try
        {
            // open input file and read each line
            BufferedReader br = new BufferedReader(new FileReader("src/BTreeIn.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            List<String> lines = new ArrayList<String>();

            // store all lines into a list
            while (line != null)
            {
                lines.add(line);   // add first
                line = br.readLine(); // then read next
            }
            
            // Insert each animal into BTree
            for (int i = 0; i < lines.size(); i++)
            {
                String animal = lines.get(i);
                // System.out.println(animal);
                tree.insert(animal);
            }
            
            //perform in-order traversal and write to output file
            tree.inOrderTraverseToFile("output.txt");
            System.out.println("Animals written to output.txt in sorted order.");

        } catch (Exception ex)
        {
            System.out.println(ex);
        }

        Scanner scanner = new Scanner(System.in);
        String input;

        // repeatedly ask user to search tree
        do
        {
            System.out.print("\nEnter an animal to search for (or type 'exit' to quit): ");
            input = scanner.nextLine().trim();

            if (!input.equalsIgnoreCase("exit"))
            {
                //start stop watch 
                StopWatch watch = new StopWatch();
                watch.start();
                
                //perform search
                boolean found = tree.search(input);

                watch.stop();
                System.out.println("Found? " + found);
                System.out.println("Search took " + watch.getRecordedMillis() + " ms");
            }

        } while (!input.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
