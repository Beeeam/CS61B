public class SLList{
    private static class IntNode{
        public int item;
        public IntNode next;
    
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;
    
    //**做一个空的list，item是随意的，目的是需要有一个dummy node只有地址指向数列的第一项*/
    public SLList(){
        sentinel = new IntNode(23,null);
        size = 0;
    }
    
    //**dummy node sentinel的下一项才是数列的第一项*/
    public SLList(int x){
        sentinel = new IntNode(23,null);
        sentinel.next = new IntNode(x,null);
        size = 1;
    }

    public void addFirst(int x){
        sentinel.next = new IntNode(x, first);
        size += 1;
    }

    public void addLast(int x){
        size += 1;
        IntNode p = sentinel;
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
        return sentinel.next.item;
    }
    
    public static void main(String[] args){
        SLList L = new SLList(10);
        L.addFirst(15);
        L.addFirst(5);
        L.addLast(11);
        System.out.println(L.getFirst());
        
    }
}
