/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 import java.io.FileWriter;
 import java.io.IOException;

/**
 *
 * @author NoahTEvans
 */
public class BTree<T extends Comparable<T>>
{

    private class BTNode
    {

        private BTNode leftNode;
        private BTNode rightNode;
        private Comparable info;

        BTNode(Comparable info)
        {
            this.info = info;
        }

        public void insert(BTNode node)
        {
            if (node.info.compareTo(this.info) <= 0)
            { // go left
                if (leftNode != null)
                {
                    leftNode.insert(node);
                } else
                {
                    leftNode = node;
                }
            } else
            { // go right
                if (rightNode != null)
                {
                    rightNode.insert(node);
                } else
                {
                    rightNode = node;
                }
            }
        }
    }

    BTNode root;

    public void insert(T info)
    {
        BTNode node = new BTNode(info);
        if (root == null)
        {
            root = node;
        } else
        {
            root.insert(node);
        }
    }
    
    public void inOrderTraverse(BTNode node) {
        if (node != null) {
            inOrderTraverse(node.leftNode);
            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(node.info.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(node.info);
            inOrderTraverse(node.rightNode);
            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(node.info.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean search(String key) {
        
    }

}
