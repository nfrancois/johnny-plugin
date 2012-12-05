package jenkins.plugins.johnny;

import jenkins.plugins.johnny.QuoteGenerator;
import junit.framework.TestCase;

public class QuoteGeneratorTest extends TestCase {

	private QuoteGenerator generator;

	public void setUp() {
		generator = new QuoteGenerator();
	}

	public void testRandomGivesAtLeast2Facts() {
		String lastFact = null;
		for (int i = 0; i < 1000000; i++) {
			String currFact = generator.random();
			if (lastFact != null && !lastFact.equals(currFact)) {
				return;
			}
			lastFact = currFact;
		}
		fail("Random should give at least 2 different facts in 1000000 tries.");
	}
}
