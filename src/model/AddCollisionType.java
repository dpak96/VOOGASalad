package model;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddCollisionType {
	private Set<String> nameList = new HashSet<String>(Arrays.asList("Left", "Right","Above","Bottom","Damage"));
	public AddCollisionType(String typeName) {
		// TODO Auto-generated constructor stub		
		add(typeName);
	}
	
	public void add(String type){
		// add new type name to the XML list
		File typeFile = new File(".\\src\\model\\CollisionTypeLibrary.xml");
		boolean typeFileExists = typeFile.exists();
		if (typeFileExists){
			LoadCollisionTypeFromXML loadCollisionType = new LoadCollisionTypeFromXML();
			ArrayList<String> loadType = loadCollisionType.getCollisionTypeList();
			loadType.add(type);
			WriteCollisionTypeToXML writeCollisionType = new WriteCollisionTypeToXML(loadType);
		}
		else{
			List<String> newString = new ArrayList<String>();
			newString.add(type);
			WriteCollisionTypeToXML newCollisionType = new WriteCollisionTypeToXML(newString);
		}
		
		File matrixFile = new File(".\\src\\model\\CollisionTypeLibrary.xml");
		boolean matrixFileExists = typeFile.exists();
		double[][] outputMatrix;
		if (matrixFileExists){
			for (String str: nameList){
				LoadMatrixFromXML loadMatrix = new LoadMatrixFromXML(str);
				double[][] tempMatrix = loadMatrix.getMatrix();
				outputMatrix = new double[tempMatrix.length+1][tempMatrix.length+1];
				for (int i = 0; i < outputMatrix.length; i++){
					for (int j = 0; j < outputMatrix.length; j++){
						if (i < outputMatrix.length-1){
							outputMatrix[i][j] = tempMatrix[i][j];
						}
						else{
							if (str.equals("Damage")){
								outputMatrix[i][j] = 0;
							}
							else{
								outputMatrix[i][j] = 1;
							}
						}
					}
				}
				WriteMatrixToXML writer = new WriteMatrixToXML(outputMatrix, str);
			}
		}
		else{
			for (String str: nameList){
				double[][] singleCell = new double[1][1];
				if (str.equals("Damage")){
					singleCell[0][0] = 0;
				}
				else{
					singleCell[0][0] = 1;
				}
				WriteMatrixToXML cellWriter = new WriteMatrixToXML(singleCell, str);
			}
		}
	}

}
