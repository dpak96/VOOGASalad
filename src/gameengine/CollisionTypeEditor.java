package gameengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Event;

public class CollisionTypeEditor {
	private List<List<List<List<Event>>>> collisionMatrix;
	private List<String> collisionTypeName;
	private final List<String> MATRIX_NAMES = new ArrayList<String>(Arrays.asList("Left","Right","Top","Bottom"));
	private final int MATRIX_NUMBER = 4;
	
	public CollisionTypeEditor() {
		// TODO Auto-generated constructor stub
		collisionTypeName = new ArrayList<String>();
		collisionMatrix = new ArrayList<List<List<List<Event>>>>();
	}
	
	private List<List<List<Event>>> createNewEventMatrix(){
		List<Event> emptyEventList = new ArrayList<Event>();
		List<List<Event>> matrixColumn = new ArrayList<List<Event>>();
		List<List<List<Event>>> fullMatrix = new ArrayList<List<List<Event>>>();
		matrixColumn.add(emptyEventList);
		fullMatrix.add(matrixColumn);
		return fullMatrix;
	}
	
	private void expandEventMatrix(List<List<List<Event>>> eventMatrix){
		for(List<List<Event>> collisionColumn : eventMatrix){
			collisionColumn.add(new ArrayList<Event>());
		}
		List<List<Event>> lastColumn = new ArrayList<List<Event>>();
		for(int j = 0; j < eventMatrix.get(0).size(); j++){
			lastColumn.add(new ArrayList<Event>());
		}
		eventMatrix.add(lastColumn);
		
	}
	
	public void add(String name){
		collisionTypeName.add(name);
		if(collisionMatrix.size() == 0){
			for(int i = 0; i < MATRIX_NUMBER; i++){
				collisionMatrix.add(createNewEventMatrix());
			}
			return;
		}
		for(int i = 0; i < MATRIX_NUMBER; i++){
			List<List<List<Event>>> directionCollisionMatrix = collisionMatrix.get(i);
			expandEventMatrix(directionCollisionMatrix);
		}
	}
	
	public void add(String direction, String nameOne, String nameTwo, Event event){
		int matrixIndex = MATRIX_NAMES.indexOf(direction);
		int typeOneIndex = collisionTypeName.indexOf(nameOne);
		int typeTwoIndex = collisionTypeName.indexOf(nameTwo);
		collisionMatrix.get(matrixIndex).get(typeOneIndex).get(typeTwoIndex).add(event);
	}
	
	public void remove(Event event){
		for(int matrixIndex = 0; matrixIndex < MATRIX_NUMBER; matrixIndex++){
			for (int typeOneIndex = 0; typeOneIndex < collisionMatrix.get(matrixIndex).size(); typeOneIndex++){
				for (int typeTwoIndex = 0; typeTwoIndex < collisionMatrix.get(matrixIndex).get(typeOneIndex).size(); typeTwoIndex++){
					collisionMatrix.get(matrixIndex).get(typeOneIndex).get(typeTwoIndex).remove(event);
				}
			}
		}
	}
	
	public List<Event> getEvents(String direction, String nameOne, String nameTwo){
		int matrixIndex = MATRIX_NAMES.indexOf(direction);
		int typeOneIndex = collisionTypeName.indexOf(nameOne);
		int typeTwoIndex = collisionTypeName.indexOf(nameTwo);
		return collisionMatrix.get(matrixIndex).get(typeOneIndex).get(typeTwoIndex);		
	}
	
	public List<String> getCollisionTypeList(){
		return collisionTypeName;
	}
}
