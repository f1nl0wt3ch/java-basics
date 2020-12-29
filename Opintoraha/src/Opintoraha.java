import java.util.Scanner;


public class Opintoraha 
{
/*Tee ohjelma Opintoraha, joka kertoo opiskelijalle maksettavan opintorahan määrän. Opiskelijalta kysytään ikä ja asumismuoto.
Esimerkkitulostus
 Itsenäisesti asuva 20 vuotta täyttänyt
298
Itsenäisesti asuva 18–19-vuotias
298
Vanhempansa luona asuva 20 vuotta täyttänyt
122
Vanhempansa luona asuva 17–19-vuotias
55
Anna ikäsi: 21
Asutko kotona (0=ei, 1=kyllä) : 1
Opintoraha on 122 euroa*/
	public static void main(String[] args) 
	{
		// Kavion esittely
		Scanner input = new Scanner(System.in);
		// muuttujien esittely
		int kyse;
		double ikä, asumismuoto;
		// pyytaminen
		System.out.print("Anna ikäsi: ");
		ikä=input.nextDouble();
		System.out.print("Asutko kotona ("+"0=ei, 1=kyllä) : ");
	    kyse=input.nextInt();
		// lasketan
		switch (kyse) 
		{
			case 1:
				if (ikä>20) 
				      {System.out.print("Opintoraha on 122 euroa");}
			    else if (ikä >= 17 && ikä<=19) 
			          {System.out.print("Opintoraha on 55 euroa");}
			break;
			case 0:
				if (ikä>20) 
			      {System.out.print("Opintoraha on 298 euroa");}
		    else if (ikä>=18 || ikä<=19) 
		          {System.out.print("Opintoraha on 298 euroa");}
			break;
			
		}
		

	}

}
