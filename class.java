public class dog {
    public int weight;
    ///**in python this is same as def __init__(self,w) self.w = w */
    ///**the name of function should be same as class name,which means Dog is wrong */
    public dog(int w){
        weight = w;
    }
    ///**non-static method a.k.a instance method so we do not claim static */
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
    //**用maxdog 和 bigger两个函数说明 static的区别，maxdog是static的与具体的dog无关，而非static与具体的dog（this）有关 */
    //**static是属于整个class的，非static属于某一个instance的，函数是class的*/
    public static dog maxdog(dog d1,dog d2){
        if (d1.weight>d2.weight){
            return d1;
        }
        return d2;
    }
    public dog bigger(dog d2){
        if (this.weight>d2.weight){
            return this;
        }
        return d2;
    }
}
public class doglaucher {
    public static void main(String[] args){
        ///**declaration */
        dog smalldog;
        ///**instantiation */
        new dog(20);
        ///**instantiation and assignment */
        smalldog = new dog(20);
        dog hugedog = new dog(150);
        smalldog.makenoise();
        hugedog.makenoise();
        dog d = new dog(15);
        dog d1 = new dog(200);
        //**两种调用方式说明了这个method是属于class还是instance */
        //**python的method是instance的 */
        dog large = dog.maxdog(d, d1);
        dog big = d.bigger(d1);
    }    
}
