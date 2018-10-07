import java.util.ArrayList;

public class Player {

	private String name;
	private Hand hand;
	private Protagonist protagonist;
	private ArrayList<Pawn> pawns;
	
	public Player(String name) {
		
		this.setName(name);
		this.setHand(new Hand());
		this.setPawns(new ArrayList<Pawn>());
		
	}
	
	public void takeCard(Player player) {
		System.out.println("Player "+this.name+ " takes from "+player.getName());
		this.hand.stealOneCard(player.getHand());
	}
	
	public void addCardsToHand(Hand hand) {
		this.hand.addCards(hand);
	}
	
	public void drawCard(Integer count, Deck deck) {
		int i = 0;
		while (i<count) {
			
			if(!deck.hasNoCards())
			this.hand.addCard(deck.drawTopCard());
			i++;
		}
		
		
	}
	public Hand drawXCardsToAHand(Integer count, Deck deck) {
		Hand hand = new Hand();
		int i = 0;
		while (i<count) {
			
			if(!deck.hasNoCards())
			hand.addCard(deck.drawTopCard());
			i++;
		}
		
		return hand;
		
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public void revealHand() {
		System.out.println(""+this.name+" holds");
		this.hand.revealHand();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Protagonist getProtagonist() {
		return protagonist;
	}

	public void setProtagonist(Protagonist protagonist) {
		this.protagonist = protagonist;
	}

	public ArrayList<Pawn> getPawns() {
		return pawns;
	}

	public void setPawns(ArrayList<Pawn> pawns) {
		this.pawns = pawns;
	}
	
	
	
}
