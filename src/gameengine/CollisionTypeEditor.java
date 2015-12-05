package gameengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Event;

public class CollisionTypeEditor {
	private List<List<List<List<Event>>>> collisionMatrix;
//	private List<List<List<Event>>> leftCollisionMatrix;
//	private List<List<List<Event>>> rightCollisionMatrix;
//	private List<List<List<Event>>> topCollisionMatrix;
//	private List<List<List<Event>>> bottomCollisionMatrix;
	private List<String> collisionTypeName;
	private final List<String> MATRIX_NAMES= new ArrayList<String>(Arrays.asList("Left","Right","Top","Bottom"));
	private final int MATRIX_NUMBER = 4;
	public CollisionTypeEditor() {
		// TODO Auto-generated constructor stub
		collisionTypeName = new ArrayList<String>();
//		leftCollisionMatrix = new ArrayList<List<List<Event>>>();
//		rightCollisionMatrix = new ArrayList<List<List<Event>>>();
//		topCollisionMatrix = new ArrayList<List<List<Event>>>();
//		bottomCollisionMatrix = new ArrayList<List<List<Event>>>();
	}
	
	public void addCollisionType(String name){
		collisionTypeName.add(name);
		List<Event> emptyEvent = new ArrayList<Event>();
		List<List<List<Event>>> emptyMatrix = new ArrayList<List<List<Event>>>();
		for (List<List<Event>> l : emptyMatrix){
			l.add(emptyEvent);
		}
		for (int i = 0; i < MATRIX_NUMBER; i++){
			collisionMatrix.add(emptyMatrix);
		}
//		
//		for (List<List<Event>> l : leftCollisionMatrix){
//			l.add(emptyEvent);
//		}
	}
	
	public void define(String direction, String nameOne, String nameTwo, List<Event> event){
		int matrixIndex = MATRIX_NAMES.indexOf(direction);
		int typeOneIndex = collisionTypeName.indexOf(nameOne);
		int typeTwoIndex = collisionTypeName.indexOf(nameTwo);
		collisionMatrix.get(matrixIndex).get(typeOneIndex).remove(typeTwoIndex);
		collisionMatrix.get(matrixIndex).get(typeOneIndex).add(typeTwoIndex, event);
	}
	
	public List<Event> getEvents(String direction, String nameOne, String nameTwo){
		int matrixIndex = MATRIX_NAMES.indexOf(direction);
		int typeOneIndex = collisionTypeName.indexOf(nameOne);
		int typeTwoIndex = collisionTypeName.indexOf(nameTwo);
		return collisionMatrix.get(matrixIndex).get(typeOneIndex).get(typeTwoIndex);		
	}
}
