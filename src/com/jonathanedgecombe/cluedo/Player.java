package com.jonathanedgecombe.cluedo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Player {
	private final int numCards;
	private final List<Turn> turns = new ArrayList<>();

	public Player(int numCards) {
		this.numCards = numCards;
	}

	public int getNumCards() {
		return numCards;
	}

	public List<Card> getKnownCards() {
		List<Card> cards = new ArrayList<>();

		for (Card card : Card.values()) {
			if (card.getOwner() == this) cards.add(card);
		}

		return cards;
	}

	public List<Turn> getTurns() {
		return turns;
	}

	public void addTurn(Turn turn) {
		turns.add(turn);
	}

	public void calculate() {
		List<Card> known = getKnownCards();

		if (known.size() == numCards) return;

		List<List<Card>> combinations = new ArrayList<>();
		permutations(known, combinations);

		Iterator<List<Card>> iterator = combinations.iterator();
		while (iterator.hasNext()) {
			List<Card> combination = iterator.next();

			if (!isValid(combination)) iterator.remove();
		}

		List<List<Card>> noDuplicates = new ArrayList<>();
		for (List<Card> cards : combinations) {
			boolean flag = true;

			for (List<Card> cards2 : noDuplicates) {
				if (ListUtil.equal(cards, cards2)) flag = false;
			}

			if (flag) noDuplicates.add(cards);
		}

		List<Card> finalList = new ArrayList<>();
		if (noDuplicates.size() == 1) {
			finalList = noDuplicates.get(0);
		} else {
			List<Card> intersection = noDuplicates.get(0);
			for (List<Card> combination : noDuplicates) {
				intersection = ListUtil.intersection(intersection, combination);
			}
	
			finalList = intersection;
		}

		for (Card card : finalList) {
			card.setOwner(this);
		}
	}

	public boolean isValid(List<Card> cards) {
		for (Turn turn : turns) {
			if (cards.contains(turn.getPerson()) || cards.contains(turn.getRoom()) || cards.contains(turn.getWeapon())) {
				if (!turn.wasShown()) return false;
			} else {
				if (turn.wasShown()) return false;
			}
		}

		return true;
	}

	public void permutations(List<Card> cards, List<List<Card>> combinations) {
		for (Card card : Card.values()) {
			if (card.getOwner() == null) {
				List<Card> clone = new ArrayList<>();
				clone.addAll(cards);

				if (clone.contains(card)) {
					continue;
				} else {
					clone.add(card);
				}

				if (clone.size() == numCards) {
					combinations.add(clone);
				} else {
					permutations(clone, combinations);
				}
			}
		}
	}
}
