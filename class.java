public class dog {
    public int weight;
    ///**in python this is same as def __init__(self,w) self.w = w */
    ///**the name of function should be same as class name,which means Dog is wrong */
    public dog(int w){
        weight = w;
    }
    public void makenoise(){
        if (weight < 10){
            System.out.println("yipyip");
        }
        else if (weight<30){
            System.out.println("bark!!!");
        }
        else{
            System.out.println("Woof!Woof!");
        }

    }
    
}
public class doglaucher {
    public static void main(String[] args){
        dog smalldog;
        new dog(20);
        smalldog = new dog(20);
        dog hugedog = new dog(150);
        smalldog.makenoise();
        hugedog.makenoise();
    }    
}
