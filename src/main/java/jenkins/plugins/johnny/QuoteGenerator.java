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

import java.util.Random;

/**
 * {@link QuoteGenerator} provides Johnny quotes.
 * 
 * @author cliffano
 * @author Nicolas François
 */
public class QuoteGenerator {

	/**
	 * The configured Johnny quotes.
	 */
	private static final String[] QUOTES = {
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
			"C'est Jésus-Christ, le premier héros de ma jeunesse. Il arrivait à attirer les foules !",
			"J’ai des goûts très ecclésiastiques.",
			"Pour les actes quotidiens, se réveiller ensemble, manger ensemble, c’est bien. C’est pas abstreignant.",
			"Il est grand temps de remettre les pendules à leur place",
			"Pour faire un couple, il faut être deux",
			"Je n'ai jamais dit «Ah que» dans une phrase, je vous le promets.",
			"Ma devise est : exister, c'est insister ",
			"Je me méfie des gens trop heureux : ils doivent avoir des choses à cacher.",
			"Je ne suis en fait qu'un vieux cow-boy fatigué de son cheval et du désert.",
			"Je ne vis pas en tant que Johnny Hallyday mais en tant que Jean-Philippe Smet.",
			"Malgré les apparences, les chauffeurs, les secrétaires, les gardes du corps, les managers qui sont tout le temps à vos côtés quand vous êtes chanteur.",
			"Clara Morgane, je ne vois pas trop qui c'est...",
			"Jouer un gangster, c'est toujours amusant. On tue plein de Chinois.",
			"De toute façon, je ne peux pas qualifier de fortune l'argent que j'ai. J'ai des maisons, c'est tout.",
			"Pour moi, le Christ c'est un rockeur qu'on crucifie.",
			"Je ne peux pas chanter n'importe quoi.",
			"Lara Fabian, c'est moi en femme. Sur scène, on dirait qu'elle fait 2,20 m. Dès qu'elle sort, on voit qu'elle a un coeur de pomme.",
			"J’ai du mal à m’imaginer écouter Johnny Hallyday. Je vis avec !",
			"Jacques Chirac ? Un type droit, humain, qui sait renvoyer l’ascenseur. Il est venu dîner à la maison. Sans gardes du corps. Serein, tranquille. Eh ben ! Je vais vous dire : il raconte des histoires grivoises pas mal du tout.",
			"Je ne serai pas un chanteur pathétique.",
			"Je n’ai jamais triché avec mon public. J’ai toujours chanté en direct.",
			"La cocaïne, j’en ai pris en tombant du lit. Maintenant, c’est fini. J’en prends pour travailler, relancer la machine. Je n’en suis pas fier. C’est ainsi, c’est tout.",
			"La médiocrité, je ne supporte pas. L’admiration, c’est important pour le respect mutuel. Je ne pourrais pas vivre avec une conne.",
			"Le rock, ça m’est venu quand j’ai entendu Loving You d’Elvis Presley. Je ne connaissais pas le rock’n roll à cette époque, je ne chantais que du Brassens. Quand je l’ai vu, je me suis dit : « C’est ça ce que je veux faire ! »",
			"Moi, tout Johnny Hallyday que je suis, je rame à chaque nouvel album, à chaque nouveau concert. Pour que ça marche, il faut aller au baston.",
			"Pour bien faire l’amour avec une femme, il faut l’avoir fait plusieurs fois. C’est toujours très mauvais la première fois !",
			"Quelques fois, j'aimerais être con.",
			"Je suis un intello (...) j’aurais pu être psy.",
			"Au théâtre, pendant une représentation du Paradis sur terre, je me suis cassé un doigt sans même m’en rendre compte. J’ai commencé à avoir mal quand le rideau est tombé. Je m’oublie totalement, corps et âme.",
			"Si Laeticia et moi on se sépare un jour, ce ne sera pas moi qui la quitterai. Ou plutôt, je sais que je ne la quitterai jamais pour une autre. Et puis, si c’est elle qui me quitte, eh bien, je sais aussi que je ne me remarierai jamais.",
			"Il reste Mick Jagger et moi.",
			"Je ne vis pas en tant que Johnny Hallyday mais en tant que Jean-Philippe Smet.",
			"En 2009, j'aurai 66 ans, ça me fera 50 ans de salles, avec tous ces jours partagés entre la scène et les hôtels. Il faut savoir s'arrêter pour faire autre chose.",
			"C'est bon, on s'en va maintenant.",
			"Il y a des rumeurs la semaine dernière comme quoi j'étais mort ! Ça arrive de temps en temps, c'est bizarre, je n'arrive pas à savoir d'où ça vient !",
			"ma qualité, je crois, c'est que je ne triche jamais. Je ne calcule rien. Je ne m'économise pas !",
			"Pourquoi mon album s'appelle l'Attente ? Parce que je passe ma vie à attendre ma femme !",
			"Ne me parlez pas de retraite, je déteste ce mot.",
			"Dans ma tête j'ai toujours 20 ans.",
			"J'envoie les sentiments dans la gueule des gens, dans leur cerveau, dans leur corps.",
			"J'admire les gens qui sont capables d'aller voir un psy. J'en suis incapable. Mon meilleur psy, c'est moi-même."
	};

	/**
	 * Random instance.
	 */
	private static final Random RANDOM = new Random();

	/**
	 * Retrieves a random quote.
	 * 
	 * @return a random quote
	 */
	public String random() {
		return QUOTES[RANDOM.nextInt(QUOTES.length)];
	}
}
