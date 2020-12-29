import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateOhjelma {
	
	/*private static String getPaiva (String Paiva)
	{
	SimpleDateFormat fdate1 = new SimpleDateFormat("E M dd hh:mm:ss zzz yyyy");
	String paiva = fdate1.format(Paiva);
	return paiva;
	}*/
public static void main(String[] args) 
{
	// Constructor allows to set year, month and date
    Calendar cal1 = new GregorianCalendar();
    // Constructor could also be empty
    // Calendar cal2 = new GregorianCalendar();
    // Change the month
    //cal1.set(Calendar.MONTH, Calendar.APRIL);

    System.out.println("Year: " + cal1.get(Calendar.DAY_OF_MONTH));
    System.out.println("Month: " + (cal1.get(Calendar.MONTH)+ 1));
    System.out.println("Days: " + cal1.get(Calendar.DAY_OF_MONTH));

    // format the output with leading zeros for days and month
    SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
    System.out.println(date_format.format(cal1.getTime()));

	/*
Scanner input = new Scanner(System.in);
Date date = new Date();


SimpleDateFormat fDate = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat fclock = new SimpleDateFormat("H");
System.out.println("Tänääm on "+ fDate.format(date));

int clock = Integer.parseInt(fclock.format(date));
if ( clock < 12)
{System.out.println("On aamupäivä");}
else if (clock > 12)
{System.out.println("On iltapäivä");}

System.out.print("Anna syntymävuotesi: ");
int synty = input.nextInt();
String vuosi = fDate.format(date).substring(0,4);
int nykyvuosi = Integer.parseInt(vuosi);
int ika;
ika = nykyvuosi - synty;
System.out.println("Täytät/olet täyttänyt tänä vuonna "+ ika );

System.out.print("Anna päivämäärä muodossa pp/kk/vvvv: ");
String strPaivamaara = input.next();
SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat df = new SimpleDateFormat("E M dd HH:mm:ss zzz yyyy");
try {Date d = dateformat.parse(strPaivamaara);
System.out.print(df.format(d));
} catch (ParseException e) {}*/
}

}
