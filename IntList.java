//**在java中共有9种类型，除了8种primitive type以外，其余的type（包括array[]）是reference type，也就是说储存的并不是值本身而是一个地址*/
//**这里IntList类型本身就是储存一个地址，该地址指向的就是下一个first*/
public class IntList {
    public int first;
    public IntList rest;

    public static void mian(String[] args){
        //**list是一个地址*/
        IntList list = new IntList();
        //**list指向的内容包含两个部分，一个是值first，一个是地址指向下一个值*/
        list.first = 5;
        list.rest = null;

        list.rest = new IntList();
        list.rest.first = 10;

        list.rest.rest = new IntList();
        list.rest.rest.first =15;
    }
    
}


public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, int r){
        first = f;
        rest = r;
    }
    //**recursion需要设定一个base case*/
    //**return the size of the list using recursion */
    public int size(){
        if (rest == null){
            return 1;
        }
        return 1+this.rest.size();
    }

    //**return the size of the list using no recursion */
    public int iterativeSize(){
        IntList p = this;
        int size = 0;
        while (p != null){
            size += 1;
            p = p.rest;
        }
        return size;
    }
    
    
    public static void main(String[] args){
        IntList list = new IntList(15,null);
        list = new IntList(10, list);
        list = new IntList(5, list);  //**这是一个[5，10，15]的list*/
        System.out.println(list.size());
    }  
}
