import java.util.Scanner;


public class Kuukaudet 

{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int [] pŠivŠt = {31,28,31,30,31,30,31,31,30,31,30,31};
		String [] kuukaudet = {"Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "KesŠkuu", "HeinŠkuu", "Elokuu, Syyskuu", "Lokakuu", "Maaraskuu", "Joulukuu"};
		 
		int numero;
		
		System.out.print("Anna kuukauden numero: ");
		numero = input.nextInt();
		int i= numero-1; 
		    
  System.out.print(pŠivŠt[(i)]+kuukaudet[(i)]);
		    
			}
			
		
	}


