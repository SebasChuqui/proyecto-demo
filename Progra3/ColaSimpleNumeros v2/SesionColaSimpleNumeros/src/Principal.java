
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColaSimNum z = new ColaSimNum();
		//z.llenar(10);
		z.adi(50);
		z.adi(20);
		z.adi(30);
		z.adi(10);
		z.adi(40);
		
		z.mostrar();
		
		System.out.println("\nNro de elementos: " + z.nroElem());
		z.eli();
		z.eli();
		System.out.println("\nNro de elementos: " + z.nroElem());
		z.mostrar();
		
	}
}
