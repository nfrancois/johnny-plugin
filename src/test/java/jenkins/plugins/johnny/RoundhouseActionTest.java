package jenkins.plugins.johnny;

import jenkins.plugins.johnny.RoundhouseAction;
import jenkins.plugins.johnny.Style;
import junit.framework.TestCase;

public class RoundhouseActionTest extends TestCase {

	private RoundhouseAction action;

	public void setUp() {
		action = new RoundhouseAction(Style.BAD_ASS,
				"Chuck Norris can divide by zero.");
	}

	public void testAccessors() {
		assertEquals(Style.BAD_ASS, action.getStyle());
		assertEquals("Chuck Norris can divide by zero.", action
				.getFact());
		assertEquals("Chuck Norris", action.getDisplayName());
		assertNull(action.getIconFileName());
		assertEquals("johnny", action.getUrlName());
	}
}
