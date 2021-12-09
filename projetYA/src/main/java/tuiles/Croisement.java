package tuiles;

import plateau.Tuile;

public class Croisement extends Tuile {
	private boolean route;
	private String occupation;
	
	public Croisement(int x, int y) {
		super(x, y,-1);
		this.route = false;
		this.occupation = "";
	}

	@Override
	public boolean estCroisement() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean estSommet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estPort() {
		// TODO Auto-generated method stub
		return false;
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

	public boolean isRoute() {
		return route;
	}

	public void setRoute(boolean route) {
		this.route = route;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String toString() {
		if(this.isRoute()) {
			return "R";
		} else {
			return " ";
		}
	}

}
