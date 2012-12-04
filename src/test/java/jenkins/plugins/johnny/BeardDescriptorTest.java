package jenkins.plugins.johnny;

import static org.mockito.Mockito.mock;
import jenkins.plugins.johnny.BeardDescriptor;
import hudson.model.AbstractProject;
import junit.framework.TestCase;

public class BeardDescriptorTest extends TestCase {

	private BeardDescriptor descriptor;

	public void setUp() {
		descriptor = new BeardDescriptor();
	}

	public void testGetDisplayName() {
		assertEquals("Activate Johnny", descriptor.getDisplayName());
	}

	public void testIsApplicableGivesTrue() {
		assertTrue(descriptor.isApplicable(mock(AbstractProject.class)
				.getClass()));
	}
}
