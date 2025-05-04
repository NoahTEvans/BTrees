/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author NoahEvans & JustinSnider
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
        
        //Insert a node into position
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
    // root of tree
    BTNode root;
    
    // wrapper for the node-creation logic
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

    //Writes contents in order to a file
    public void inOrderTraverseToFile(String filename)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename)))
        {
            inOrderTraverse(root, writer);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    // recursive helper
    private void inOrderTraverse(BTNode node, PrintWriter writer)
    {
        if (node != null)
        {
            inOrderTraverse(node.leftNode, writer);
            writer.println(node.info.toString());
            inOrderTraverse(node.rightNode, writer);
        }
    }
    
    //searches the tree for a key
    public boolean search(T key)
    {
        return searchHelper(root, key);
    }
    
    //recursive search helper 
    private boolean searchHelper(BTNode node, T key)
    {
        if (node == null)
        {
            return false;
        }
        int cmp = key.toString().compareToIgnoreCase(node.info.toString());
        if (cmp == 0)
        {
            return true;
        } else if (cmp < 0)
        {
            return searchHelper(node.leftNode, key);
        } else
        {
            return searchHelper(node.rightNode, key);
        }
    }
}
