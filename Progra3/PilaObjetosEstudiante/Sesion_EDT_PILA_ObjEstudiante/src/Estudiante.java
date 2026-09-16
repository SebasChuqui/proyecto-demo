
public class Estudiante {
	private String nom;
	private String carrera;
	private int nota;
	
	public Estudiante(String nom, String carrera, int nota) {
		this.nom = nom;
		this.carrera = carrera;
		this.nota = nota;
	}

	public String getNom() {
		return nom;
	}

	public String getCarrera() {
		return carrera;
	}

	public int getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return "Estudiante [nom=" + nom + ", carrera=" + carrera + ", nota=" + nota + "]";
	}
	
	public void mostrar() {
		System.out.println(toString());
	}
	
}
