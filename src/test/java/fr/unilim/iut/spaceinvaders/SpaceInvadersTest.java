package fr.unilim.iut.spaceinvaders;

import org.junit.Before;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;

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
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(7,9), 1);
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
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(14,10), 1);
	}

	
	@Test
	public void test_unNouveauVaisseauAvecDimensionEstCorrectementPositionneDansEspaceJeu() {
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9), 1);
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
	
	@Test
	public void test_UnNouveauVaisseauPositionneDansEspaceJeuMaisAvecDimensionTropGrande_DoitLeverUneExceptionDeDebordement() {
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(9,2),new Position(7,9), 1);
			fail("Dépassement du vaisseau à droite en raison de sa longueur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
		} catch (final DebordementEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,4),new Position(7,1), 1);
			fail("Dépassement du vaisseau vers le haut en raison de sa hauteur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
		} catch (final DebordementEspaceJeuException e) {
		}
			
	}
	
    
    @Test
	public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {
		
    	spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(12,9), 3);
		spaceinvaders.deplacerVaisseauVersLaDroite();
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"............VVV\n" + 
		"............VVV\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
    
    @Test
 	public void test_VaisseauAvance_DeplacerVaisseauVersLaGauche() {
    	  spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9), 3);
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
          "....VVV........\n" + 
          "....VVV........\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());	
     }
    
    @Test
	public void test_VaisseauImmobile_DeplacerVaisseauVersLaGauche() {
		
    	spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(0,9), 3);
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
        "VVV............\n" + 
        "VVV............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
    
    public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {

        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9),4);
        spaceinvaders.deplacerVaisseauVersLaDroite();
        assertEquals("" + 
        "...............\n" + 
        "...............\n" +
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "..........VVV..\n" + 
        "..........VVV..\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }
    
    @Test
    public void test_VaisseauAvancePartiellement_DeplacerVaisseauVersLaDroite() {

       spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(10,9),3);
       spaceinvaders.deplacerVaisseauVersLaDroite();
       assertEquals("" + 
       "...............\n" + 
       "...............\n" +
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "............VVV\n" + 
       "............VVV\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }
    
    @Test
    public void test_VaisseauAvancePartiellement_DeplacerVaisseauVersLaGauche() {

       spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(1,9), 3);
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
       "VVV............\n" + 
       "VVV............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
     }

    @Test
    public void test_MissileBienTireDepuisVaisseau_VaisseauLongueurImpaireMissileLongueurImpaire() {

	   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 2);
	   spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

      assertEquals("" + 
      "...............\n" + 
      "...............\n" +
      "...............\n" + 
      "...............\n" + 
      "...............\n" + 
      "...............\n" + 
      ".......MMM.....\n" + 
      ".......MMM.....\n" + 
      ".....VVVVVVV...\n" + 
      ".....VVVVVVV...\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
   }
    
	   @Test(expected = MissileException.class)
		public void test_PasAssezDePlacePourTirerUnMissile_UneExceptionEstLevee() throws Exception { 
		   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 1);
		   spaceinvaders.tirerUnMissile(new Dimension(7,9),1);
		}
}
