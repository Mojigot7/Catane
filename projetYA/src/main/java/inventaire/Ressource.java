package inventaire;

public enum Ressource {
	BOIS(0),ARGILE(0),LAINE(0),MINERAI(0),BLE(0);
	private int quantite;
	
	private Ressource(int quantite) {
		this.setQuantite(quantite);
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
