package fr.unilim.iut.spaceinvaders.model;

public class Collision {

	public static boolean detecterCollision(SpaceInvaders spaceinvaders) {

		if ((spaceinvaders.aUnMissile()) && (spaceinvaders.aUnEnvahisseur())) {
			if (envahisseurEtMissileSontEnContact(spaceinvaders)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	public static boolean envahisseurEtMissileSontEnContact(SpaceInvaders spaceinvaders) {
		return envahisseurEtMissileOntLaMemeAbscisse(spaceinvaders)
						&& envahisseurEtMissileOntLaMemeOrdonnee(spaceinvaders);
	}

	public static boolean envahisseurEtMissileOntLaMemeOrdonnee(SpaceInvaders spaceinvaders) {
		return spaceinvaders.missile
				.estOrdonneeCouverte(spaceinvaders.envahisseur.ordonneeLaPlusBasse());
	}

	public static boolean envahisseurEtMissileOntLaMemeAbscisse(SpaceInvaders spaceinvaders) {
		return envahisseurEtCoteDroitDuMissileOntLaMemeAbscisse(spaceinvaders)
				|| envahisseurEtCoteGaucheDuMissileOntLaMemeAbscisse(spaceinvaders);
	}

	public static boolean envahisseurEtCoteGaucheDuMissileOntLaMemeAbscisse(SpaceInvaders spaceinvaders) {
		return spaceinvaders.envahisseur.estAbscisseCouverte(spaceinvaders.missile.abscisseLaPlusAGauche());
	}

	public static boolean envahisseurEtCoteDroitDuMissileOntLaMemeAbscisse(SpaceInvaders spaceinvaders) {
		return spaceinvaders.envahisseur.estAbscisseCouverte(spaceinvaders.missile.abscisseLaPlusADroite());
	}

}
