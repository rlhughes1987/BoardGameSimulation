
public class Card {

	//parent
	private String label;
	private String type;
	private String description;
	
	public Card() {
	
		this.setType("Blank");
		this.setLabel("Blank");
		this.setDescription("Blank");
	}
	
	public Card(Card card) {
		this.label = card.getLabel();
		this.type = card.getType();
		this.description = card.getDescription();
	}
	
	// Getters and Setters

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
