public class LinkedListDeque<T> {
    private static class Node<T>{
        public T item;
        public Node<T> prev;
        public Node<T> next;

        public Node( Node<T> p, T i, Node<T> n){
            item = i;
            prev = p;
            next = n;
        }

    }
    private Node<T> sentinel;
    private int size;


   
    public LinkedListDeque(){
        Node head = new Node<T>(null, null, null);
        head.prev = head;
        head.next = head;
        sentinel = head;
        // Node first = new Node<T>(sentinel, item, sentinel);
        // sentinel.next = first;
        // sentinel.prev = first;
        // size = 1;
        size = 0;
    }
    

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(T item){
        Node newNode = new Node<T>(null, item, null);
        newNode.prev = sentinel;
        if (size == 0){            
            newNode.next = sentinel;            
            sentinel.prev = newNode;
        }else{newNode.next = sentinel.next;}
        sentinel.next = newNode;
        size = size+1;
    }

    public void addLast(T item){
        Node newNode = new Node<T>(null, item, null);
        newNode.prev = sentinel.prev;
        sentinel.prev.next = newNode;
        newNode.next = sentinel;
        sentinel.prev = newNode;
        size = size+1;
    }

    public void printDeque(){
        Node p = sentinel.next;
        System.out.println("the deque is ");
        while(p!=sentinel){
            System.out.print(p.item+" ");
            p = p.next;
        }
        System.out.println("\n");
    }

    public void removeFirst(){
        Node p = sentinel.next;
        if (p == sentinel){
            System.out.println("null");
        }else{           
            System.out.println("the removed item is "+p.item);
            p.next.prev = sentinel;
            sentinel.next = p.next;
        }    
    }

    public void removeLast(){
        Node p = sentinel.prev;
        if (p == sentinel){
            System.out.println("null");
        }else{           
            System.out.println("the removed item is "+p.item);
            p.prev.next = sentinel;
            sentinel.prev = p.prev;
        } 
    }

    public T get(int index){
        Node<T> p = sentinel;
        if (p.next==sentinel || index>=size){
            return null;
        }
        while(index>=0){
            p = p.next;
            index = index-1;
        }
        return p.item;
    }

    public static void main(String[] args){
        LinkedListDeque L = new LinkedListDeque();
        L.addFirst(15);
        L.addLast(5);
        L.addFirst(11);
        L.addLast(2);
        System.out.println("the size is "+L.size());
        L.printDeque();
        L.removeFirst();
        L.printDeque();
        L.removeLast();
        L.printDeque();
        System.out.println("the item is "+L.get(0));
    }  
}
