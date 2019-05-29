package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.model.Collision;
import fr.unilim.iut.spaceinvaders.model.Dimension;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;

public class CollisionTest {
	private SpaceInvaders spaceinvaders;
	
	@Before
	public void initialisation() {
		spaceinvaders = new SpaceInvaders(15, 10);
	}
	
	 @Test
		public void test_UnEnvahisseurDisparaitApresAvoirRecuUnMissileQuiDisparatiAussi() {
		 	spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 2);
		 	spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(2,1),new Position(8,0), 0);
			
		 	spaceinvaders.tirerUnMissile(new Dimension(3,2),1);
			spaceinvaders.deplacerMissile();
			spaceinvaders.deplacerMissile();
			spaceinvaders.deplacerMissile();
			spaceinvaders.deplacerMissile();
			spaceinvaders.deplacerMissile();
			spaceinvaders.deplacerMissile();
			   
			if (Collision.detecterCollision(spaceinvaders)) {
			   spaceinvaders.changerEnvahisseur(null);
			   spaceinvaders.changerMissile(null);
			}
			
			assertEquals("" +
			"...............\n" +
			"...............\n" +
			"...............\n" +
			"...............\n"	+
			"...............\n" +
			"...............\n" +
			"...............\n" +
			"...............\n"	+
			".....VVVVVVV...\n" +
			".....VVVVVVV...\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	
	
}
