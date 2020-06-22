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
    private int size;

    public SLList(int x){
        first = new IntNode(x,null);
        size = 1;
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
        size += 1;
    }

    public void addLast(int x){
        size += 1;
        IntNode p = first;
        while(p.next!= null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }
    
//     private static int size(IntNode p){
//         if(p.next==null){
//             return 1;
//         }
//         return 1+size(p.next);
//     }

//     public int size(){
//         return size(first);    
//     }
    public int size(){
        return size;
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
