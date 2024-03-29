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

import hudson.model.Action;

/**
 * {@link JohnnyAction} keeps the style and quote associated with the action.
 * @author cliffano
 * @author Nicolas François
 */
public final class JohnnyAction implements Action {

    /**
     * The style - for backward compatibility to version 0.2.
     */
    private Style style;
    
    /**
     * The style.
     */
    private Style mStyle;

    /**
     * The quote - for backward compatibility to version 0.2.
     */
    private String quote;
    
    /**
     * The quote.
     */
    private String mQuote;

    /**
     * Constructs a RoundhouseAction with specified style and quote.
     * @param style
     *            the style
     * @param quote
     *            the quote
     */
    public JohnnyAction(final Style style, final String quote) {
        super();
        this.mStyle = style;
        this.mQuote = quote;
    }

    /**
     * Gets the action display name.
     * @return the display name
     */
    public String getDisplayName() {
        return "Johnny";
    }

    /**
     * This action doesn't provide any icon file.
     * @return null
     */
    public String getIconFileName() {
        return null;
    }

    /**
     * Gets the URL name for this action.
     * @return the URL name
     */
    public String getUrlName() {
        return "johnny";
    }

    /**
     * Gets the Johhny style.
     * @return the style
     */
    public Style getStyle() {
        Style theStyle;
        if (mStyle != null) {
            theStyle = mStyle;
        } else {
            theStyle = style;
        }
        return theStyle;
    }

    /**
     * Gets the Johnny quote.
     * @return the quote
     */
    public String getQuote() {
        String theQuote;
        if (mQuote != null) {
        	theQuote = mQuote;
        } else {
        	theQuote = quote;
        }
        return theQuote;
    }
}
