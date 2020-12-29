import java.util.Scanner;
public class Veriryhma {
static String valinta;
static Scanner input = new Scanner(System.in);

public void kysyVeriryhma(String [] veriryhmat, int MAX, String valinta) {
veriryhmat = new String [MAX];
int lkm =0 ;
String veriStr;
do {lkm++;
System.out.print("Anna veriryhmä: ");
veriStr = input.nextLine();
veriryhmat [lkm] = veriStr;
}while (lkm < MAX && !veriStr.matches("[-]"));
int j =0;
for (int i=0; i< lkm; i++){
if (valinta.equals(veriryhmat[i])){j++;}
} 
}
public void naytaVeriryhma(String [] veriryhmat, int lkm, String valinta, int j) {
	
	System.out.println("Luovutuksia oli yhteensä "+ (lkm -1));
	System.out.println("Veriryhmän "+ valinta + "luovutuksia oli: "+ j);
}
public static void main ( String[] args)
{
final int MAX = 1000, j=0;
String veriryhmat []= new String[MAX];
Veriryhma ohjelma = new Veriryhma();

ohjelma.kysyVeriryhma(veriryhmat, MAX, valinta);
System.out.println("Minkä veriryhmän luovutusten määrän haluat tietää: ");
String valinta = input.next();

ohjelma.naytaVeriryhma(veriryhmat, j, valinta, j);
}
}
