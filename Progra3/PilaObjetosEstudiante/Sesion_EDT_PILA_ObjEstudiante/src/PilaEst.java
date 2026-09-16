import java.util.Scanner;

public class PilaEst extends VectorEst{
private int tope;
	
	public PilaEst() {
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
	public void adi(Estudiante dato) {
		if(!esLlena()) {
			tope++;
			v[tope] = dato;
		}else {
			System.out.println("Pila Llena!!");
		}
	}
	public Estudiante eli() {
		Estudiante dato = null;
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
	
	public void vaciar(PilaEst p) {
		while(!p.esVacia()) {
			this.adi(p.eli());
		}
	}
	public void mostrar() {
		PilaEst aux = new PilaEst();
		while(!this.esVacia()) {
			Estudiante x = this.eli();
			System.out.println(x);
			aux.adi(x);
		}
		this.vaciar(aux);
	}
	public void llenar(int n) {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. " + n + " datos");
		System.out.println("nom - carrera - nota");
		for (int i = 1; i <= n; i++) {
			//String x = lee.next();
			String nom = lee.next();
			String carrera = lee.next();
			int nota = lee.nextInt();
					
			Estudiante x = new Estudiante(nom, carrera, nota);
			this.adi(x);
		}
	}
	
}
