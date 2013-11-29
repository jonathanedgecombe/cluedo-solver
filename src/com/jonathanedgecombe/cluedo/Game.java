package com.jonathanedgecombe.cluedo;

import java.util.ArrayList;
import java.util.List;

public final class Game {
	private final List<Player> players = new ArrayList<>();

	public void addPlayer(Player player) {
		players.add(player);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public static void main(String[] args) {
		/*
		 * such test
		 * many players
		 * wow
		 */

		Game game = new Game();

		Player player1 = new Player(5);
		Player player2 = new Player(5);
		Player player3 = new Player(4);
		Player player4 = new Player(4);

		game.addPlayer(player1);
		game.addPlayer(player2);
		game.addPlayer(player3);
		game.addPlayer(player4);

		Card.PERSON_COLONEL_MUSTARD.setOwner(player1);
		Card.PERSON_MISS_SCARLETT.setOwner(player2);
		Card.PERSON_MRS_PEACOCK.setOwner(player3);
		//Card.PERSON_MRS_WHITE.setOwner(player4);
		Card.PERSON_PROFESSOR_PLUM.setOwner(player1);

		Card.WEAPON_CANDLESTICK.setOwner(player2);
		Card.WEAPON_DAGGER.setOwner(player3);
		//Card.WEAPON_LEAD_PIPING.setOwner(player4);
		Card.WEAPON_REVOLVER.setOwner(player1);
		Card.WEAPON_ROPE.setOwner(player2);

		Card.ROOM_BALLROOM.setOwner(player3);
		Card.ROOM_BILLIARD_ROOM.setOwner(player4);
		Card.ROOM_CONSERVATORY.setOwner(player1);
		Card.ROOM_DINING_ROOM.setOwner(player2);
		Card.ROOM_HALL.setOwner(player3);
		Card.ROOM_KITCHEN.setOwner(player4);
		Card.ROOM_LIBRARY.setOwner(player1);
		Card.ROOM_LOUNGE.setOwner(player2);

		player4.addTurn(new Turn(Card.PERSON_MRS_WHITE, Card.WEAPON_CANDLESTICK, Card.ROOM_BALLROOM, true));
		player4.addTurn(new Turn(Card.PERSON_MISS_SCARLETT, Card.WEAPON_LEAD_PIPING, Card.ROOM_BALLROOM, true));

		player4.calculate();

		System.out.println(player4);
		System.out.println(Card.PERSON_MRS_WHITE.getOwner());
	}
}
