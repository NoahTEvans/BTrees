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
        private T info;

        BTNode(T info)
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
        
        public boolean search(T key) {
            int compareResult = key.compareTo(info);
            if (compareResult == 0) {
                return true;
            } else if (compareResult < 0)
            { // go left
                if (leftNode != null)
                {
                    return leftNode.search(key);
                } else
                {
                    return false;
                }
            } else
            { // go right
                if (rightNode != null)
                {
                    return rightNode.search(key);
                } else
                {
                    return false;
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
    
    public boolean search(T key) {
        if (root == null) {
            return false;
        } else if (root.info == key) {
            return true;
        } else {
            return root.search(key);
        }
    }

}
