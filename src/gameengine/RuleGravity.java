package gameengine;

public class RuleGravity extends Rule{

	private double yAcceleration;
	
	public RuleGravity(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void apply(Article art) {
		art.setYVelocity(art.getYVelocity() + yAcceleration);
	}

}
