package plateau;

public abstract class Tuile {
	private int x;
	private int y;
	private int numero;
	
	public Tuile(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.numero = num;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public abstract boolean estCroisement();
	public abstract boolean estSommet();
	public abstract boolean estPort();
	public abstract boolean estTuile();
	public abstract boolean peutEtreVoleur();

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString() {
		return this.getNumero()+"";
	}
}
