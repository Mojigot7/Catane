package inventaire;

public enum Ressource {
	BOIS(0,"bois"),ARGILE(0,"argile"),LAINE(0,"laine"),MINERAI(0,"minerai"),BLE(0,"ble");
	private int quantite;
	private String nom;
	
	private Ressource(int quantite, String nom) {
		this.setQuantite(quantite);
		this.nom = nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getNom() {
		return nom;
	}
}
