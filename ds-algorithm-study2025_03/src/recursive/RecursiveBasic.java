package recursive;

public class RecursiveBasic {

public static void recursive(int n){
    System.out.println(n + " ");
    if(n-1 >0)
        recursive(n-1);
}

    public static void main(String[] args) {
    recursive(3);
    }
}
