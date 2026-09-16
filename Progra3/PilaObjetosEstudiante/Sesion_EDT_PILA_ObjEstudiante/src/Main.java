
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PilaEst p = new PilaEst();
		//System.out.println(p.nroElem());
		//p.llenar(5);
		Estudiante e1 = new Estudiante("Pedro", "Informatica", 50);
		Estudiante e2 = new Estudiante("Maria", "Estadistica", 67);
		Estudiante e3 = new Estudiante("Carlos", "Informatica", 88);
		Estudiante e4 = new Estudiante("Ana", "Matematica", 45);
		Estudiante e5 = new Estudiante("Luis", "Informatica", 75);
		
		p.adi(e1);
		p.adi(e2);
		p.adi(e3);
		p.adi(e4);
		p.adi(e5);
		
		p.mostrar();
		
	}

}
