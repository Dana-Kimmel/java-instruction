package kimmel.app;

public class Dice {

	// Field declaration
	private Die die1;
	private Die die2;

	// Constructors
	public Dice() {
		die1 = new Die();
		die2 = new Die();
	}

	public Dice(Die die1, Die die2) {
		this.die1 = die1;
		this.die1 = die2;
	}

	// Getters and Setters
	public int getDie1() {
		return die1.getValue();
	}

	public int getDie2() {
		return die2.getValue();
	}

	public void setDie1(Die die1) {
		this.die1 = die1;
	}

	public void setDie2(Die die2) {
		this.die2 = die2;
	}

}
