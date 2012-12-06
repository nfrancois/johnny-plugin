package jenkins.plugins.johnny;

import jenkins.plugins.johnny.JohnnyAction;
import jenkins.plugins.johnny.Style;
import junit.framework.TestCase;

public class JohnnyActionTest extends TestCase {

	private JohnnyAction action;

	public void setUp() {
		action = new JohnnyAction(Style.BAD_ASS, "Les gens m'appellent l'idole des jeunes...");
	}

	public void testAccessors() {
		assertEquals(Style.BAD_ASS, action.getStyle());
		assertEquals("Les gens m'appellent l'idole des jeunes...", action.getQuote());
		assertEquals("Johnny", action.getDisplayName());
		assertNull(action.getIconFileName());
		assertEquals("johnny", action.getUrlName());
	}
}
