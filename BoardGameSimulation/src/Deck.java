import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards;
	private String name;
	private Integer maxSize;
	
	public Deck(String name, Integer maxSize) {
		
		this.setMaxSize(maxSize);
		this.cards = new ArrayList<Card>();
		this.name = name;
	}
	
	public void fillWithBlanks() {
		int i = this.cards.size();
		
		while(i<this.maxSize) {
			Card card = new Card();
			card.setLabel(""+i);
			this.addCard(card);
			i++;
		}
	}
	
	public boolean hasNoCards() {
		if(this.cards.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public Card drawTopCard() {
		Card topCard = new Card(this.cards.get(0));
		this.cards.remove(0);
		//System.out.println("Card "+topCard.getLabel());
		return topCard;
	}
	
	public void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
	
	public void printDeck() {
		for(Card card: this.cards) {
			System.out.println(""+card.getLabel());
		}
	}
	
	// Getters and Setters
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxSize() {
		return this.maxSize;
	}

	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}
	
}
