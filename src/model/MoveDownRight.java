package model;

public class MoveDownRight extends SingleDependencyRule {

	private double defaultAccel;
	
	public MoveDownRight(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void apply(Article a) {
		a.moveDown(defaultAccel);
		
	}

}
