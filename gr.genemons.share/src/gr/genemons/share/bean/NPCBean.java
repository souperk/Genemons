package gr.genemons.share.bean;

public class NPCBean extends EntityBean {

	private static final long serialVersionUID = -1376228082930580730L;

	private int speed;
	private double direction = 0;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

}
