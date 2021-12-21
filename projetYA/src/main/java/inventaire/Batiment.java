package inventaire;

public enum Batiment {
	ROUTE(2),COLONIE(2),VILLE(0);
	private int quantite;
	
	private Batiment(int quantite) {
		this.setQuantite(quantite);
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
