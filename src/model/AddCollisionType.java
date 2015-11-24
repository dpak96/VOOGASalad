package model;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddCollisionType {
	private Set<String> nameList = new HashSet<String>(Arrays.asList("Left", "Right","Above","Bottom","Damage"));
	private String myTypeName;
	public AddCollisionType(String typeName) {
		// TODO Auto-generated constructor stub	
		myTypeName = typeName;
	}
	
	public void add(){
		// add new type name to the XML list
		File typeFile = new File(".\\src\\model\\CollisionTypeLibrary.xml");
		boolean typeFileExists = typeFile.exists();
		if (typeFileExists){
			LoadCollisionTypeFromXML loadCollisionType = new LoadCollisionTypeFromXML();
			ArrayList<String> loadType = loadCollisionType.getCollisionTypeList();
			loadType.add(myTypeName);
			WriteCollisionTypeToXML writeCollisionType = new WriteCollisionTypeToXML(loadType);
		}
		else{
			List<String> newString = new ArrayList<String>();
			newString.add(myTypeName);
			WriteCollisionTypeToXML newCollisionType = new WriteCollisionTypeToXML(newString);
		}
		
		
		double[][] outputMatrix;
			for (String str: nameList){
				File matrixFile = new File(".\\src\\model\\"+str+"CollisionLibrary.xml");
				boolean matrixFileExists = matrixFile.exists();
				if (matrixFileExists){
				LoadMatrixFromXML loadMatrix = new LoadMatrixFromXML(str);
				double[][] tempMatrix = loadMatrix.getMatrix();
				outputMatrix = new double[tempMatrix.length+1][tempMatrix.length+1];
				System.out.println("length: "+outputMatrix.length);
				for (int i = 0; i < outputMatrix.length; i++){
					for (int j = 0; j < outputMatrix.length; j++){
						if (i < outputMatrix.length-1 && j < outputMatrix.length-1){
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
			else{
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
