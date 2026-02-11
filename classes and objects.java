package info;
class Mobile {
    String brand;
    int price;
    void details(){
        System.out.println("Brand:"+brand);
        System.out.println("Price:"+price);

    }
}
public class Pri{
	public static void main(String[] args){
        Mobile m=new Mobile();
        m.brand="Samsung s24 ultraa";
        m.price=150000;
        m.details();
	}
}

