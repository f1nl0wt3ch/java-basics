import java.sql.SQLException;
import java.util.*;

public class AjaKanta {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean onAuki = false;
		List<Leffa> leffat = new ArrayList<Leffa>();
		DBHoitaja tkhandleri = new DBHoitaja();
		try {
			onAuki = tkhandleri.yhdista();
			if (onAuki) {
				leffat = tkhandleri.haeLeffat();
				for (int i = 0; i < leffat.size(); i++)
					System.out.println(leffat.get(i).toString());
			} else
				System.out.println("Leffatietoja ei löydy ");
		} catch (SQLException e) {
			System.out.println("\n**** Virhetilanne ****\n" + e.getMessage());
		}
	}

}
