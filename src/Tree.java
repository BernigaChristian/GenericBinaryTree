import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 05/05/2022, giovedì
 **/
public class Tree {
    private int elements;
    private Node root;

    public Tree(){
        root = null;
        elements = 0;
    }
    public void add(String s){
        Node n = new Node(s);
        if(root == null)    root = n;
        else add(root,n);
    }
    private void add(Node temp,Node n){
        int sx = getSons(temp.getSx(),0),dx = getSons(temp.getDx(),0);
        if(sx == 0){
            temp.setSx(n);
            return;
        }
        else if(dx == 0){
            temp.setDx(n);
            return;
        }
        else add(sx <= dx ? temp.getSx() : temp.getDx(),n);
    }
    public int getSons(Node root, int sons){
        if(root == null)    return sons;
        else sons ++;
        return getSons(root.getSx(),sons) + getSons(root.getDx(),sons);
    }
    public void visit(){
        visit(root);
    }
    private void visit(Node temp){
        if(temp == null)    return;
        visit(temp.getSx());
        System.out.print(temp.getInfo() + "\t");
        visit(temp.getDx());

    }
    public void print(){
        alg.TreePrinter.print(root);
    }
    private boolean isThere(Node temp,String n){
        if(temp == null) return false;
        else if(temp.getInfo().contains(n)) return true;
        else if(isThere(temp.getSx(),n))    return true;
        else if(isThere(temp.getDx(),n))    return true;
        else return false;
    }
    public void lumberjack(String s){
        if(!isThere(root,s)) System.out.println("the char sequence is not present in the tree");
        else if(root.getInfo().contains(s)) root = null;
        else lumberjack(root,s);
    }
    private void lumberjack(Node temp,String s){
        if(temp == null)    return;
        if(temp.getSx() != null && temp.getSx().getInfo().contains(s)) temp.setSx(null);
        else if(temp.getDx() != null && temp.getDx().getInfo().contains(s))    temp.setDx(null);
        lumberjack(temp.getDx(),s);
        lumberjack(temp.getSx(),s);
    }
}

class Test{
    public static void main(String[] args) {
        Tree t = new Tree();
        for(int i = 0; i < 26; i++) t.add(Character.toString((char)i + 'a').toUpperCase(Locale.ROOT));
        t.print();
        t.lumberjack("B");
        t.print();
    }
}