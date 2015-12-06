package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gameengine.CollisionTypeEditor;

public class PresetCollision {
	private List<List<List<List<Event>>>> collisionMatrix;
	private List<String> collisionTypeName;
	private CollisionTypeEditor myCollisionTypeEditor;
	private final List<String> DEFAULT_TYPES= new ArrayList<String>(Arrays.asList("player","platform","enemy"));
	public PresetCollision(CollisionTypeEditor editor) {
		// TODO Auto-generated constructor stub
		myCollisionTypeEditor = editor;
	}
	
	public void intialize(){
		for (String s: DEFAULT_TYPES){
			myCollisionTypeEditor.add(s);
		}
		Event stopHorizontalVelocity = getStopHorizontalVelocityEvent();
		Event bounce = getBounceEvent();
	}

	private Event getBounceEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	private Event getStopHorizontalVelocityEvent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CollisionTypeEditor getCollisonTypeEditor(){
		return myCollisionTypeEditor;
	}

}
