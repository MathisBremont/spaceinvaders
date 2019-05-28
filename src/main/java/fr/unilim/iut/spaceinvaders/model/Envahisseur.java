package fr.unilim.iut.spaceinvaders.model;

public class Envahisseur extends Sprite {
	
	 Direction direction;
	 
	 
	 
	public Envahisseur(Dimension dimensionEnvahisseur, Position origineEnvahisseur, int vitesseEnvahisseur) {
		super(dimensionEnvahisseur,origineEnvahisseur,vitesseEnvahisseur);
		this.direction = direction.DROITE;
	}
}
