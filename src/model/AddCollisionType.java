package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddCollisionType {
	private Set<String> nameList = new HashSet<String>(Arrays.asList("Left", "Right","Above","Bottom","Damage"));
	public AddCollisionType(String typeName) {
		// TODO Auto-generated constructor stub		
		add(typeName);
	}
	
	public void add(String type){
		// add new type name to the XML list
		LoadCollisionTypeFromXML loadCollisionType = new LoadCollisionTypeFromXML();
		ArrayList<String> loadType = loadCollisionType.getCollisionTypeList();
		loadType.add(type);
		WriteCollisionTypeToXML writeCollisionType = new WriteCollisionTypeToXML(loadType);
		
		for (String str: nameList){
			LoadMatrixFromXML loadMatrix = new LoadMatrixFromXML(str);
			double[][] tempMatrix = loadMatrix.getMatrix();
			double[][] newMatrix = new double[tempMatrix.length+1][tempMatrix.length+1];
			for (int i = 0; i < newMatrix.length; i++){
				for (int j = 0; j < newMatrix.length; j++){
					if (i < newMatrix.length-1){
						newMatrix[i][j] = tempMatrix[i][j];
					}
					else{
						if (str.equals("Damage")){
							newMatrix[i][j] = 0;
						}
						else{
							newMatrix[i][j] = 1;
						}
					}
				}
			}
		}
	}

}
