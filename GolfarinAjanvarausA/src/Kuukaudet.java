import java.util.Scanner;


public class Kuukaudet 

{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int [] p�iv�t = {31,28,31,30,31,30,31,31,30,31,30,31};
		String [] kuukaudet = {"Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kes�kuu", "Hein�kuu", "Elokuu, Syyskuu", "Lokakuu", "Maaraskuu", "Joulukuu"};
		 
		int numero;
		
		System.out.print("Anna kuukauden numero: ");
		numero = input.nextInt();
		int i= numero-1; 
		    
  System.out.print(p�iv�t[(i)]+kuukaudet[(i)]);
		    
			}
			
		
	}


