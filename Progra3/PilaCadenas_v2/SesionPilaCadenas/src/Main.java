
public class Main {

	public static void main(String[] args) {
		
		//A) Dado una pila de nombres de departamentos
		//mostrar los departamentos que tienen mayor
		//longitud
		
		Pila A =  new Pila();
		A.adi("Santa Cruz");
		A.adi("La Paz");
		A.adi("OruroOruro");
		A.adi("Cochabamba");
		A.adi("Pando");
		A.adi("Beni");
		
		A.mostrar();
		
		//procedimiento para resolver el problema
		mostrarCadMayorLongitud(A); 
		
		//B) Dado una pila de departamentos, llevar a otra 
		//pila los departamentos que tienen longitud igual
		//a x. mostrar las pilas resultantes!
		Pila C = new Pila();
		C = separaCadenasLongitud(A);
		A.mostrar();
		C.mostrar();
	
	}
	public static Pila separaCadenasLongitud(Pila A) {
		
		//terminar de implementar
		
		//return ;
	}
	
	
	public static void mostrarCadMayorLongitud(Pila A) {
		int may = encontrarMayorLongitud(A);
		Pila aux = new Pila();
		System.out.println("\nCadenas de mayor longitud:");
		while(!A.esVacia()) {
			String x = A.eli();
			if(x.length() == may) {
				System.out.println(x);
			}
			aux.adi(x);
		}
		A.vaciar(aux);
	}
	public static int encontrarMayorLongitud(Pila A) {
		int may = 0;
		Pila aux = new Pila();
		while(!A.esVacia()) {
			String x = A.eli();
			if(x.length() > may) {
				may = x.length();
			}
			aux.adi(x);
		}
		A.vaciar(aux);
		return may;
	}
	

}
