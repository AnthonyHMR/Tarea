package sumatoria;

import java.util.Scanner;

public class Sumain {

	public static void main(String args[]) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Dame el primer valor: ");
		int valorUno = entrada.nextInt();
		
		System.out.println("Dame el segundo valor: ");
		int valorDos = entrada.nextInt();
		
		suma valores = new suma(valorUno, valorDos);
		valores.Imprimir();
		entrada.close();
	}

}
