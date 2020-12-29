import java.text.DecimalFormat;
import java.util.Scanner;
public class Metodit {
      
	public double laskeKulutus(int kilometrit, int tankattu) {
		 
		
		final int matka = 100;
		
		 double kulutus = (tankattu*matka )/ kilometrit;
		
		
	    return kulutus;
	}
	
	public void naytaKulutus(double kulutus) {
		
		System.out.println("Kulutus/100km on "+ kulutus +" litraa");
		    }
public static void main(String[] args) 
	
	{ 
	 
	  Metodit ohjelma = new Metodit();
	  
	  Scanner input = new Scanner(System.in);
		System.out.println("Anna ajetut kilometrit: ");
	   int kilometrit = input.nextInt();
		System.out.println("Anna tankattu määrä: ");
		int tankattu = input.nextInt();
		
	  
	  double kulutus = ohjelma.laskeKulutus(kilometrit, tankattu);
	  ohjelma.naytaKulutus(kulutus);
	/*
	    double tulo;
	    static int ika;
	public double kysyTulo() { // tao method hoi thu nhap ca nhan
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("Anna vuositulot ja ikäsi: ");
		tulo = input.nextDouble();
		ika = input.nextInt();
		
		return tulo;
	
	}
	
	public double laskeYlevero(double tulot, int ika) { // tao method tinh thue thu nhap ca nhan
		
		double ylevero;
		ylevero = (tulo*0.68) / 100; // cong thuc tinh thue thu nhap ca nhan
		// ylevero la thue thu nhap ca nhan, ikä la tuoi cua nguoi dung. 
		if ( ylevero > 140 && ika >= 18) {ylevero = 140; }
		else if ( tulo < 7353 || ika < 18 ) { ylevero = 0; }
		else { ylevero = (tulo*0.68) / 100;}
		return ylevero;
		}
	
	public static void main(String[] args) 
	
	{ 
		DecimalFormat fm = new DecimalFormat("0.00");
		// goi cac method va in ket qua ra man hinh 
		Metodit ohjelma = new Metodit();
		double tulo, ylevero;
		tulo = ohjelma.kysyTulo();
		ylevero = ohjelma.laskeYlevero(tulo, ika);
		System.out.print("Ylevero on: "+ fm.format(ylevero));
		*/
		
	}

}
