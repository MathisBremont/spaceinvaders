package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.model.Dimension;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class EnvahisseurTest {
	
	private SpaceInvaders spaceinvaders;
	
	@Before
	public void initialisation() {
		spaceinvaders = new SpaceInvaders(15, 10);
	}
	
    @Test
	public void test_unNouveauEnvahisseurAvecDimensionEstCorrectementPositionneDansEspaceJeu() {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(2,1),new Position(8,0), 1);
		assertEquals("" +
		"........EE.....\n" +
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
    
	@Test(expected = HorsEspaceJeuException.class)
	public void test_unNouveauEnvahisseurEstPositionneHorsEspaceJeuTropEnBas_UneExceptionEstLevee() throws Exception {
		spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(1,1),new Position(14,10), 1);
	}
	
	@Test
	public void test_UnNouveauEnvahisseurPositionneDansEspaceJeuMaisAvecDimensionTropGrande_DoitLeverUneExceptionDeDebordement() {
		try {
			spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(9,2),new Position(7,9), 1);
			fail("Dépassement de l'envahisseur à droite en raison de sa longueur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
		} catch (final DebordementEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(3,4),new Position(7,1), 1);
			fail("Dépassement de l'envahisseur vers le haut en raison de sa hauteur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
		} catch (final DebordementEspaceJeuException e) {
		}
			
	}
	
	@Test
    public void test_VaisseauAvance_DeplacerEnvahisseurVersLaDroite() {

        spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(3,2),new Position(7,1),3);
        spaceinvaders.deplacerEnvahisseurVersLaDroite();
        assertEquals("" + 
        "..........EEE..\n" + 
        "..........EEE..\n" +
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }
	
    @Test
	public void test_EnvahisseurImmobile_DeplacerEnvahisseurVersLaDroite() {
		
    	spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(3,2),new Position(12,1), 1);
		spaceinvaders.deplacerEnvahisseurVersLaDroite();
		assertEquals("" + 
		"............EEE\n" + 
		"............EEE\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
    
    @Test
 	public void test_VaisseauAvance_DeplacerVaisseauVersLaGauche() {
    	  spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(3,2),new Position(7,1), 3);
          spaceinvaders.deplacerEnvahisseurVersLaGauche();

          assertEquals("" + 
          "....EEE........\n" + 
          "....EEE........\n" +
          "...............\n" + 
          "...............\n" + 
          "...............\n" + 
          "...............\n" + 
          "...............\n" + 
          "...............\n" + 
          "...............\n" + 
          "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());	
     }
    
    
    
    @Test
	public void test_EnvahisseurImmobile_DeplacerEnvahisseurVersLaGauche() {
		
    	spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(3,2),new Position(0,1), 1);
		spaceinvaders.deplacerEnvahisseurVersLaGauche();
		assertEquals("" + 
		"EEE............\n" + 
		"EEE............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
    
    @Test
    public void test_EnvahisseurAvancePartiellement_DeplacerVaisseauVersLaDroite() {

       spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(3,2),new Position(11,1),3);
       spaceinvaders.deplacerEnvahisseurVersLaDroite();
       assertEquals("" + 
       "............EEE\n" + 
       "............EEE\n" +
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }
    
    @Test
    public void test_EnvahisseurAvancePartiellement_DeplacerEnvahisseurVersLaGauche() {

       spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(3,2),new Position(1,1), 3);
       spaceinvaders.deplacerEnvahisseurVersLaGauche();

       assertEquals("" + 
       "EEE............\n" + 
       "EEE............\n" +
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
     }
}
