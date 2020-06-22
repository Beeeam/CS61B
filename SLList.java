public class SLList{
    private static class IntNode{
        public int item;
        public IntNode next;
    
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    private IntNode first;

    public SLList(int x){
        first = new IntNode(x,null);
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    public void addLast(int x){
        IntNode p = first;
        while(p.next!= null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public int getFirst(){
        return first.item;
    }
    public static void main(String[] args){
        SLList L = new SLList(10);
        L.addFirst(15);
        L.addFirst(5);
        L.addLast(11);
        System.out.println(L.getFirst());
        
    }
}
