package fr.unilim.iut.spaceinvaders;

import org.junit.Before;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.model.Dimension;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;
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

}
