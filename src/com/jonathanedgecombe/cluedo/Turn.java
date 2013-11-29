package com.jonathanedgecombe.cluedo;

public final class Turn {
	private final Card person, weapon, room;
	private final boolean shown;

	public Turn(Card person, Card weapon, Card room, boolean shown) {
		this.person = person;
		this.weapon = weapon;
		this.room = room;
		this.shown = shown;
	}

	public Card getPerson() {
		return person;
	}

	public Card getWeapon() {
		return weapon;
	}

	public Card getRoom() {
		return room;
	}

	public boolean wasShown() {
		return shown;
	}
}
