/**find the maximunm element of a list*/
public class helloworld {
    public static int max(int []a){
		int max = a[0];
        for (int i=1;i < a.length;i++){
	    	if (a[i]>max){
				max = a[i];
           }
        }
        return max;
    }
    public static void main(String[] args){
        int[] a = new int[]{8, 2, -1, -1, 15};
        System.out.println(max(a));
    }
}

/**selcet three numbers (can be same) in the list and find if their sum is 0*/
public class helloworld {
    public static boolean 3sum(int []a){
        for (int i=0;i < a.length-2;i++){
            for (int j=i;j< a.length-1;j++){
                for (int k=j;k< a.length; k++){
                    if(a[i] + a[j]+ a[k] == 0){
                        return true;
                    }
                }

            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] a = new int[]{8, 2, -1, -1, 15};
        System.out.println(3sum(a));
    }
}

/**selcet three diffrent numbers in the list and find if their sum is 0*/
public class helloworld {
    public static boolean 3sum_distinct(int []a){
        for (int i=0;i < a.length-2;i++){
            for (int j=i+1;j< a.length-1;j++){
                for (int k=j+1;k< a.length; k++){
                    if(a[i] + a[j]+ a[k] == 0){
                        return true;
                    }
                }

            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] a = new int[]{8, 2, -1, -1, 15};
        System.out.println(3sum_distinct(a));
    }
}
