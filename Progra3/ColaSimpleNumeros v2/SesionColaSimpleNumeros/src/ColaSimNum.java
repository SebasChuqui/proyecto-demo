import java.util.Scanner;

public class ColaSimNum extends ColaNum{
	public ColaSimNum() {
		super();
	}
	public int nroElem() {
		return (fi - fr);
	}
	public boolean esVacia() {
		if(this.fi == this.fr)
			return true;
		return false;
		
	}
	public boolean esLlena() {
		if(this.fi == MAX-1)
			return true;
		return false;
	}
	public void adi(int elem) {
		if(!esLlena()) {
			fi = fi + 1;
			v[fi] = elem;
		}else
			System.out.println("cola Llena!!!");
	}
	public int eli() {
		int elem = -1;
		if(!esVacia()) {
			fr = fr + 1;
			elem = v[fr];
		}else
			System.out.println("Cola Vacia!!");
		return elem;
	}
	
	public void vaciar(ColaSimNum z) {
		while(!z.esVacia()) {
			adi(z.eli());
		}
	}
	public void llenar(int n) {
		Scanner lee = new Scanner(System.in);
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Intr. numero entero");
			int elem = lee.nextInt();
			adi(elem);
		}
	}
	public void mostrar() {
		ColaSimNum aux = new ColaSimNum();
		while(!esVacia()) {
			int elem = eli();
			System.out.print(elem + "\t");
			aux.adi(elem);
		}
		vaciar(aux);
	}
}
