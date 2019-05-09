package fr.unilim.iut.spaceinvaders;

import org.junit.Before;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvadersTest {

	private SpaceInvaders spaceinvaders;

	@Before
	public void initialisation() {
		spaceinvaders = new SpaceInvaders(15, 10);
	}

	@Test
	public void test_AuDebut_JeuSpaceInvaderEstVide() {
		assertEquals("" +
	"...............\n" +
	"...............\n" +
	"...............\n" +
	"...............\n"	+
	"...............\n" +
	"...............\n" +
	"...............\n" +
	"...............\n"	+
	"...............\n" +
	"...............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());

	}

	@Test
	public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
		spaceinvaders.positionnerUnNouveauVaisseau(1,1,7, 9);
		assertEquals("" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n"	+
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n"	+
		"...............\n" +
		".......V.......\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}

	@Test(expected = HorsEspaceJeuException.class)
	public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnBas_UneExceptionEstLevee() throws Exception {
		spaceinvaders.positionnerUnNouveauVaisseau(1,1,14, 10);
	}

	@Test
	public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {
		spaceinvaders.positionnerUnNouveauVaisseau(1,1,7, 9);

		spaceinvaders.deplacerVaisseauVersLaDroite();

		assertEquals("" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n"	+
		"...............\n" +
		"........V......\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}

	@Test
	public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {

		spaceinvaders.positionnerUnNouveauVaisseau(1,1,14, 9);

		spaceinvaders.deplacerVaisseauVersLaDroite();

		assertEquals("" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n"	+
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n"	+
		"...............\n" +
		"..............V\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}

	@Test
	public void test_VaisseauAvance_DeplacerVaisseauVersLaGauche() {

		spaceinvaders.positionnerUnNouveauVaisseau(1,1,7, 9);

		spaceinvaders.deplacerVaisseauVersLaGauche();

		assertEquals("" +
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"......V........\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}

	@Test
	public void test_VaisseauImmobile_DeplacerVaisseauVersLaGauche() {

		spaceinvaders.positionnerUnNouveauVaisseau(1,1,0, 9);

		spaceinvaders.deplacerVaisseauVersLaGauche();

		assertEquals("" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n" +
		"...............\n"	+
		"...............\n" +
		"V..............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
	
	@Test
	public void test_unNouveauVaisseauAvecDimensionEstCorrectementPositionneDansEspaceJeu() {
		spaceinvaders.positionnerUnNouveauVaisseau(3,2,7,9);
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		".......VVV.....\n" + 
		".......VVV.....\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
}
