package tuiles;

import plateau.Tuile;

public class Port extends Tuile {

	public Port(int x, int y) {
		super(x, y, -1);
	}

	@Override
	public boolean estCroisement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSommet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estPort() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean estTuile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean peutEtreVoleur() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return " ";
	}

}
