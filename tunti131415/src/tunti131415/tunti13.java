package tunti131415;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
public class tunti13 {

	public static void main(String[] args)
	
	{
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
		Date today = new Date();
		System.out.println("Tänään on "+dateformat.format(today));
		System.out.println("Kello on "+timeformat.format(today));
		
		Scanner input = new Scanner(System.in);
		System.out.print("Anna syntymäpäiväsi (pp.kk.vvvv): ");
		String strPaiva = input.next();
		
		SimpleDateFormat synty = new SimpleDateFormat("yyyy");
        Date date = new Date();
		
		 
        try {
        date = synty.parse(strPaiva.substring(7, 4));
	     System.out.print("Syntymävuotesi on "+ date );
        } catch (ParseException e) {System.out.print("ei onnistu");}
		
		
		

	}

}
