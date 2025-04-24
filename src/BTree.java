/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rocky
 */
public class BTree<T extends Comparable<T>>
{
    private class BTNode {
        
        BTNode leftNode;
        BTNode rightNode;
        Comparable info;
        
        BTNode(Comparable info) {
            this.info = info;
        }
    
        public void insert(BTNode node) {
            switch (this.info.compareTo(node)) {
                case -1, 0:
                    if (leftNode != null) {
                        leftNode.insert(node);
                    } else {
                        leftNode = node;
                    }
                    break;
                case 1:
                    if (rightNode != null) {
                        rightNode.insert(node);
                    } else {
                        rightNode = node;
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    BTNode root;
    
    public void insert(T info) {
        BTNode node = new BTNode(info);
        if (root == null) {
            root = node;
        } else {
            root.insert(node);
        }
    }
    
}
