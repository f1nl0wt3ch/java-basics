import java.util.Scanner;
import java.text.DecimalFormat;
public class Ylevero 
{

	public static void main(String[] args) 
	{
		
			// kavion esittely
			Scanner input = new Scanner(System.in);
			DecimalFormat fm = new DecimalFormat("0.00");
			DecimalFormat fm1 = new DecimalFormat("0.0");
			// muuttujien esittely
			
			double vuositulot, ik�, ylevero;
			// pyytaminen
			System.out.println("Anna vuositulosi ja ik�si: ");
	vuositulot = input.nextDouble();
			ik� = input.nextDouble();
			// laskenta
			ylevero = vuositulot*0.68 / 100 ;
			
			      
			if (vuositulot < 7353 || ik� < 18) {
					System.out.print("Ylevero on 0" );
			}
					
					else if (ylevero > 140) {
					System.out.println("Ylevero on 140,00");
				} 
			else 	 {
					System.out.print("Ylevero on "+ fm.format(ylevero));
				} 
		
			 
		        
		

	}

}
