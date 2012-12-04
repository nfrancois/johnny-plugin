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
package hudson.plugins.johnny;

import java.util.Random;

/**
 * {@link FactGenerator} provides Chuck Norris facts.
 * @author cliffano
 */
public class FactGenerator {

    /**
     * The configured Chuck Norris facts, from <a href="http://www.codesqueeze.com/the-ultimate-top-25-chuck-norris-the-programmer-jokes/"
     * >http://www.codesqueeze.com/the-ultimate-top-25-chuck-norris-the-
     * programmer-jokes/</a>.
     */
    private static final String[] FACTS = {
            "Je n'ai jamais cherché le pourquoi du comment...",
            "Pour faire un couple, il faut être deux.",
            "Si je dois dix centimes au fisc, on vient me les saisir. Un jour, les huissiers ont même emporté mes blousons",
            "Je suis souvent seul dans la vie, mais sur scène jamais... Ma drogue à moi, c'est le public.",
            "Je vis avec moi-même tous les jours",
            "Si on avait pas perdu une heure, on serait arrivés une heure plus tôt.",
            "La poudre et le hasch circulent à mort chez les musiciens. Il n'y a pas à s'en vanter, je n'en suis pas fier, c'est ainsi, c'est tout. Mais il faut bien savoir que nos chansons, on ne les sort pas forcément d'une pochette-surprise.",
            "A Los Angeles, je peux acheter mes sauces piquantes sans qu'on se jette sur moi, de temps en temps ça fait du bien ! ",
            "Il n'y a pas de honte à faire de la pub, ca aide à payer les réparations du toit de la maison ! ",
            "En voyant le public, j'oublie que j'ai mal",
            "Les gens m'appellent l'idole des jeunes...",
            "Je ne suis jamais seul, à moins que je lis.",
            "Je vis au jour le jour, pour demain, pas pour hier.",
            "J’aimerais apprendre à dire non pour ne plus me retrouver à dire oui sans faire attention.",
            "Est-ce que vous les connaissez ces joueurs de l’équipe de France de Football ? – Oui, je connais Zazie évidemment…",
            "Ma devise est : exister, c'est insister !",
            "Ce qui rend heureux, c'est d'être heureux.",
            "C'est Jésus-Christ, le premier héros de ma jeunesse. Il arrivait à attirer les foules !"
    };

    /**
     * Random instance.
     */
    private static final Random RANDOM = new Random();

    /**
     * Retrieves a random fact.
     * @return a random fact
     */
    public String random() {
        return FACTS[RANDOM.nextInt(FACTS.length)];
    }
}
