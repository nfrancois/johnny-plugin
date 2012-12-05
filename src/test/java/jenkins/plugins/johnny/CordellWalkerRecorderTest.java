package jenkins.plugins.johnny;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Build;
import hudson.model.BuildListener;
import hudson.model.Result;

import java.util.ArrayList;
import java.util.List;

import jenkins.plugins.johnny.CordellWalkerRecorder;
import jenkins.plugins.johnny.QuoteGenerator;
import jenkins.plugins.johnny.RoundhouseAction;
import jenkins.plugins.johnny.Style;

import junit.framework.TestCase;

public class CordellWalkerRecorderTest extends TestCase {

	private QuoteGenerator mockGenerator;
	private CordellWalkerRecorder recorder;

	@Override
	public void setUp() {
		mockGenerator = mock(QuoteGenerator.class);
		recorder = new CordellWalkerRecorder(mockGenerator);
	}

	public void testGetProjectActionWithNoLastBuildGivesNullAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		when(mockProject.getLastBuild()).thenReturn(null);
		assertNull(recorder.getProjectAction(mockProject));
	}

	public void testGetProjectActionHavingLastBuildGivesRoundhouseAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		Build mockBuild = mock(Build.class);

		when(mockProject.getLastBuild()).thenReturn(mockBuild);
		when(mockBuild.getResult()).thenReturn(Result.SUCCESS);
		when(mockGenerator.random()).thenReturn(
				"Les gens m'appellent l'idole des jeunes...");

		Action action = recorder.getProjectAction(mockProject);

		assertTrue(action instanceof RoundhouseAction);
		assertEquals(Style.THUMB_UP, ((RoundhouseAction) action).getStyle());
		assertNotNull(((RoundhouseAction) action).getQuote());
	}

	public void testPerformWithFailureResultAddsRoundHouseActionWithBadAssStyleAndExpectedFact()
			throws Exception {
		List<Action> actions = new ArrayList<Action>();
		AbstractBuild mockBuild = mock(AbstractBuild.class);
		when(mockBuild.getResult()).thenReturn(Result.FAILURE);
		when(mockBuild.getActions()).thenReturn(actions);

		when(mockGenerator.random()).thenReturn(
				"Les gens m'appellent l'idole des jeunes...");

		assertEquals(0, actions.size());

		recorder.perform(mockBuild, mock(Launcher.class),
				mock(BuildListener.class));

		assertEquals(1, actions.size());
		assertTrue(actions.get(0) instanceof RoundhouseAction);
		assertEquals(Style.BAD_ASS, ((RoundhouseAction) actions.get(0))
				.getStyle());
		assertEquals("Les gens m'appellent l'idole des jeunes...",
				((RoundhouseAction) actions.get(0)).getQuote());
	}
}
