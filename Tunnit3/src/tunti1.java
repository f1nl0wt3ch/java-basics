import java.text.DecimalFormat;
import java.util.Scanner;


public class tunti1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		double myyntihinta;
		double myyntipalkkio;
		double valityspalkkio = ( 344 )/ 10000;
		System.out.print("Anna asunnon myyntihinta: ");
		myyntihinta = input.nextDouble();
		myyntipalkkio = myyntihinta*valityspalkkio;
		if (myyntipalkkio >= 2214){ myyntipalkkio = myyntihinta*valityspalkkio;
			
		}
		else { myyntipalkkio = 2214.00;}
		
		System.out.print("Myyntipalkkio on "+ fm.format(myyntipalkkio));
	}

}
