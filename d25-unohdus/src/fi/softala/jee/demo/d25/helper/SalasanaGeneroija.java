package fi.softala.jee.demo.d25.helper;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SalasanaGeneroija {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Anna salasana:");
		String salasana = input.nextLine();
		String suola = null;
		String salasanaKryptattuna = null;
		try {
			suola = Salaaja.generoiSuola();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			salasanaKryptattuna = Salaaja.salaa(salasana, suola, "SHA-512", 100);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("salasana: " + salasanaKryptattuna);
		System.out.println("suola: " + suola);
	}

}
