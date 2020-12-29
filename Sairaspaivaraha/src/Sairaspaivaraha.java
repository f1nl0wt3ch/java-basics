import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;


public class Sairaspaivaraha {
	
	
public int kysyLampotilat(int[] lampotilat, final int MAX) {
		int lkm = 0, lampotila;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Anna lämpötila: ");
	    lampotila = input.nextInt();
		while (lkm < MAX && lampotila != -999) {
			lampotilat[lkm] = lampotila;
			lkm++;
		
	    System.out.print("Anna lämpötila: ");
	    lampotila = input.nextInt();
	   
	    } 
		
       return lkm;
 }
public void naytaLampotilat(int[] lampotilat, int lkm) {
		
		 
	Arrays.sort(lampotilat, 0, lkm);
	for ( int i= 0; i < lkm; i++)
	   {
	
		System.out.print(lampotilat[i] + " ");}
	 
	
	}
public static void main ( String[] args) {
		Sairaspaivaraha ohjelma = new Sairaspaivaraha();
		final int MAX = 99;
		int [] lampotilat = new int[MAX];
		int lkm = ohjelma.kysyLampotilat(lampotilat, MAX);
		ohjelma.naytaLampotilat(lampotilat, lkm);
		
	    
	    
	}
	

	}


