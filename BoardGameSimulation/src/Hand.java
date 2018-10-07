import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	
	private ArrayList<Card> cards;
	
	public Hand() {
		this.setCards(new ArrayList<Card>());
	}
	
	public Hand(Hand hand) {
		this.cards = new ArrayList<Card>();
		
		for(Card card : hand.getCards()) {
			this.cards.add(new Card(card));
		}

	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
		Collections.shuffle(this.cards);
	}
	
	public void giveCardToOtherHand(String label, Hand otherHand) {
		for(Card card : this.cards) {
			if(card.getLabel().equals(label)) {
				otherHand.addCard(new Card(card));
			}
		}
	}
	
	public void addCards(Hand hand) {
		
		for(Card card : hand.getCards()) {
			
			Card newCard = new Card(card);
			this.cards.add(newCard);
			
		}
		
		Collections.shuffle(this.cards);
	}
	
	public int size() {
		return this.cards.size();
	}
	
	public void revealHand() {
		
		String line = "";
		
		
		for (Card c : this.cards) {
			line+=c.getLabel()+",";
		}
		
		if (!(line.equals(""))) {
			System.out.println(line.substring(0,line.length()-1));
		} else {
			System.out.println("<Empty>");
		}
		
		
	}
	
	public Card takeOneRandom() {
		Collections.shuffle(this.cards);
		
		Card card = new Card(this.cards.get(0));
		System.out.println("Took "+this.cards.get(0).getLabel());
		this.cards.remove(0);
		
		return card;
	}
	
	
	public void stealOneCard(Hand hand) {
		this.cards.add(hand.takeOneRandom());
		Collections.shuffle(this.cards);
	}
	
	public ArrayList<Card> removeCardsWithLabel(String label) {

		ArrayList<Card> removedCards = new ArrayList<Card>();
		
		for(int i=0;i<this.cards.size();i++) {
			if(this.cards.get(i).getLabel().equals(label)) {
				Card removedCard = new Card(this.cards.get(i));
				removedCards.add(removedCard);
				this.cards.remove(i);
			}
		}
		
		return removedCards;
	}

}
