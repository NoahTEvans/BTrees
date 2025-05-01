
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author justinsnider
 */
public class BTreeMain
{

    /**
     * @param args the command line arguments
     * "C:\Users\rocky\OneDrive\Desktop\BTree Data File.txt"
     */
    public static void main(String[] args)
    {

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("/Users/justinsnider/Desktop/BTreeDataFile.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            List<String> lines = new ArrayList<String>();

            while (line != null)
            {
                lines.add(line);   // add first
                line = br.readLine(); // then read next
            }

            BTree tree = new BTree();

            for (int i = 0; i < lines.size(); i++)
            {
                String animal = lines.get(i);
                System.out.println(animal);
                tree.insert(animal);
            }

        } catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
