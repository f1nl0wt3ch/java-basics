import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

public class Pizzalista {
	
	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	boolean onAuki = false;
		   List <Pizza> pizzaLista = new  ArrayList <Pizza>();
		    DBHoitaja tkhandleri = new DBHoitaja();
		    try {
				onAuki = tkhandleri.yhdista();
				if (onAuki){
					pizzaLista = tkhandleri.haePizza();
					for (int i = 0; i< pizzaLista.size();i++)
						System.out.println(pizzaLista.get(i).toString());
				}
				else
						System.out.println("Pizzatietoja ei lšydy ");
			} catch (SQLException e) {
				System.out.println("\n**** Virhetilanne ****\n" + e.getMessage());
			}
	}

}

