import alg.TreePrinter;

public  class Node implements TreePrinter.PrintableNode {
    private String info;
    private Node sx;
    private Node dx;

    public Node(String o) {
        info = o;
        sx = null;
        dx = null;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Node getSx() {
        return sx;
    }

    public Node getDx() {
        return dx;
    }

    public void setSx(Node sx) {
        this.sx = sx;
    }

    public void setDx(Node dx) {
        this.dx = dx;
    }

    @Override
    public String toString(){
        return "[" + info+ "]";
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return sx;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return dx;
    }

    @Override
    public String getText() {
        return info;
    }
}