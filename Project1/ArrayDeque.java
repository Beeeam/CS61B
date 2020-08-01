public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front = 0;
    private int back = 0;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T item){
        if (size == items.length){
            resize(size*2);
        }
        if (isEmpty()){
            items[front] = item;
        }
        else{
            front = (front-1)&(items.length-1);
            //与(front-1)%(items.length)一个意思 */
            //**https://stackoverflow.com/questions/28314798/addfirst-method-of-arraydeque-class */
            items[front] = item;
        }
        size = size+1;
    }

    public void addLast(T item){
        if (size == items.length){
            resize(size*2);
        }
        if (isEmpty()){
            items[back] = item;
        }
        else{
            back = (back+1)&(items.length-1);
            items[back] = item;
        }
        size = size+1;
    }

    public void printDeque(){
        System.out.println("the deque is ");
        int i = front;
        while(items[i]!=null & i!=back+1){          
            System.out.println(items[i]);
            i=(i+1)&(items.length-1);
        }        
        System.out.println("\n");
    }

    public T removeFirst(){
        T a = items[front];
        front = (front+1) & (items.length-1);
        size = size-1;
        return a;
    }

    public T removeLast(){
        T a = items[back];
        back = (back-1) & (items.length-1);
        size = size-1;
        return a; 
    }

    public T get(int index){
        return items[index];
    }

    public static void main(String[] args){
        ArrayDeque L = new ArrayDeque<>();
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
