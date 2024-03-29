/**
 * Copyright (c) 2009 Cliffano Subagio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jenkins.plugins.johnny;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;

import java.io.IOException;
import java.util.logging.Logger;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * This class associates a JohnnyAction to a job or a build.
 * @author cliffano
 * @author Nicolas François
 */
public class JohnnyRecorder extends Recorder {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(JohnnyRecorder.class.getName());

    /**
     * Quote generator.
     */
    private QuoteGenerator quoteGenerator;

    /**
     * Constructs a {@link JohnnyRecorder} with default
     * {@link QuoteGenerator}.
     */
    @DataBoundConstructor
    public JohnnyRecorder() {
        this(new QuoteGenerator());
    }

    /**
     * Constructs a {@link JohnnyRecorder} with specified
     * {@link QuoteGenerator}.
     * @param quoteGenerator
     *            the quote generator
     */
    public JohnnyRecorder(final QuoteGenerator quoteGenerator) {
        this.quoteGenerator = quoteGenerator;
        LOGGER.info("Johnny is activated");
    }

    /**
     * Gets the JohnnyAction as the project action. This is applicable for
     * each job and only when there's at least one build in the job.
     * @param project 
     *            the project
     * @return the project action
     */
    @Override
    public final Action getProjectAction(final AbstractProject<?, ?> project) {
        Action action = null;
        if (project.getLastBuild() != null) {
            Style style = Style.get(project.getLastBuild().getResult());
            String quote = quoteGenerator.random();
            action = new JohnnyAction(style, quote);
        }
        return action;
    }

    /**
     * Adds JohnnyAction to the build actions. This is applicable for each
     * build.
     * @param build
     *            the build
     * @param launcher
     *            the launcher
     * @param listener
     *            the listener
     * @return true
     * @throws InterruptedException
     *             when there's an interruption
     * @throws IOException
     *             when there's an IO error
     */
    @Override
    public final boolean perform(final AbstractBuild<?, ?> build,
            final Launcher launcher, final BuildListener listener)
            throws InterruptedException, IOException {
        Style style = Style.get(build.getResult());
        String quote = quoteGenerator.random();
        build.getActions().add(new JohnnyAction(style, quote));
        return true;
    }

    /**
     * Gets the required monitor service.
     * @return the BuildStepMonitor
     */
    public final BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }
}
