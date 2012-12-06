package jenkins.plugins.johnny;

import static org.mockito.Mockito.mock;
import jenkins.plugins.johnny.JohnnyDescriptor;
import hudson.model.AbstractProject;
import junit.framework.TestCase;

public class JohnnyDescriptorTest extends TestCase {

	private JohnnyDescriptor descriptor;

	public void setUp() {
		descriptor = new JohnnyDescriptor();
	}

	public void testGetDisplayName() {
		assertEquals("Activate Johnny", descriptor.getDisplayName());
	}

	public void testIsApplicableGivesTrue() {
		assertTrue(descriptor.isApplicable(mock(AbstractProject.class)
				.getClass()));
	}
}
