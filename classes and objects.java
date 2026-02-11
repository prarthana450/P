package info;
class Calculator {
    int n1,n2;
    void sum(){
        int add=n1+n2;
        System.out.println("sum:"+add);

    }
}
public class Pri{
    public static void main(String[] args){
        Calculator c=new Calculator();
        c.n1=15;
        c.n2=15;
        c.sum();

    }

}
