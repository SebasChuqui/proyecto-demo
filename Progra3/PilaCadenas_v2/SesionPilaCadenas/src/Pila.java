import java.util.Scanner;

public class Pila extends Vector {
	private int tope;
	
	public Pila() {
		this.tope = -1;
	}
	public boolean esVacia() {
		if(tope == -1)
			return true;
		return false;
	}
	public boolean esLlena() {
		if(tope == MAX-1 )
			return true;
		return false;
	}
	public void adi(String dato) {
		if(!esLlena()) {
			tope++;
			v[tope] = dato;
		}else {
			System.out.println("Pila Llena!!");
		}
	}
	public String eli() {
		String dato = "";
		if(!esVacia()) {
			dato = v[tope];
			tope--;
		}else
			System.out.println("Pila Vacia!!");
		
		return dato;
	}
	public int nroElem() {
		return ++tope;
	}
	
	public void vaciar(Pila p) {
		while(!p.esVacia()) {
			this.adi(p.eli());
		}
	}
	public void mostrar() {
		Pila aux = new Pila();
		while(!this.esVacia()) {
			String x = this.eli();
			System.out.println(x);
			aux.adi(x);
		}
		this.vaciar(aux);
	}
	public void llenar(int n) {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. " + n + " datos");
		for (int i = 1; i <= n; i++) {
			String x = lee.next();
			this.adi(x);
		}
	}
	
	
}
