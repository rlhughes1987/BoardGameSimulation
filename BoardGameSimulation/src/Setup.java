import java.util.ArrayList;

import javax.swing.JFrame;

public class Setup {

	private ArrayList<Dice> dices;
	private ArrayList<Player> players;
	private Deck deck;
	
	
	public Setup() {
		
		this.dices = new ArrayList<Dice>();
		this.players = new ArrayList<Player>();
		
		final int NUM_OF_DICE = 3;
		final int DICE_SIDES = 6;
		final int NUM_OF_CARDS = 52;
		
		int dice_iterator=0;
		
		while(dice_iterator < NUM_OF_DICE){
			
			this.dices.add(new Dice(DICE_SIDES));
			dice_iterator++;
		}
		
		this.deck = new Deck("Deck",NUM_OF_CARDS);
		this.deck.fillWithBlanks();
		this.deck.shuffleDeck();
		
		this.players.add(new Player("Rich"));
		this.players.add(new Player("Veronika"));
		this.players.add(new Player("Paul"));
		
	}
	
	public Player getPlayer(int index) {
		return this.players.get(index);
	}
	
	public ArrayList<Player> getPlayers(){
		return this.players;
	}
	
	public Deck getDeck() {
		return this.deck;
	}
	
	/*
	public void startGame() {
		
		this.deck.fillWithBlanks();
		//this.deck.printDeck();
		System.out.println("-----Shuffled Deck------");
		this.deck.shuffleDeck();
		this.deck.printDeck();
		System.out.println("-----Players Draw Cards------");
		for (Player p : this.players) {
			System.out.println(""+p.getName()+" draws");
			p.drawCard(4, this.deck);
		}

		for(int i=0; i<5; i++) {
			this.players.get(0).takeCard(this.players.get(1));
			this.players.get(1).takeCard(this.players.get(0));
			this.players.get(0).revealHand();
			this.players.get(1).revealHand();
		}
		
		
		
		
		/*
		for( Dice d : this.dices) {
			d.rollDice();
		}
		
		if(Mechanic.checkResultFor(8,this.dices)){
			
		}
		
	} */

	
	
}
