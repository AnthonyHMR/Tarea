package sumatoria;

public class suma {
	private int vUno, vDos, Resultado;
	
	public suma(int valorUno, int valorDos) {
		this.vUno = valorUno;
		this.vDos = valorDos;
	}
	public void Operacion() {
		Resultado = vUno + vDos;
		
	}
	public void Imprimir() {
		Operacion();
		System.out.println("El resultado es: " + Resultado);
	}
	
}
