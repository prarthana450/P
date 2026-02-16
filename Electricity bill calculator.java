//write a program to calculate electricity bill first 100 units 5rs per unit next 100 units 7rs per unit above 200 units 10rs per unit
import java.util.Scanner;
public class Calculator{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr the number of  units");
		int units=sc.nextInt();
		 double BA = (units <= 100) 
                 ? (units * 5) 
                 : (units <= 200) 
                   ? (100 * 5) + ((units - 100) * 7) 
                   : (100 * 5) + (100 * 7) + ((units - 200) * 10);
		/*if(units<=100) {
			BA=units*5;
		}else if(units<=200) {
			BA=(100*5)+(100-units)*7;
		}
		else {
			BA=(100*5)+(100*7)+((200-units)*10);
		}*/
		System.out.println("Bill amount "+BA);
	}
}
