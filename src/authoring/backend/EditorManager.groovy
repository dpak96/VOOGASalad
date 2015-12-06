package authoring.backend

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import model.controller.ModelController;
import resourcemanager.ResourceManager;


public class EditorManager extends Editor {
	private Map<String, Editor> editorMap;


	public EditorManager(ModelController modelController) {
		super(modelController);
		this.register(modelController);
	}

	public void register(ModelController mc){
		ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "Reflection");
		editorMap = new HashMap<String, Editor>();
		for(String x: rb.keySet()){
			editorMap.put(x, getNewInstance(rb.getString(x)));
		}
	}

	private getNewInstance(String cName){
		Class<?> cl = Class.forName(cName);
		Constructor<?> ctor = cl.getConstructor(ModelController.class);
		Object[] o = new Object[1];
		o[0] = myModelController;
		Object object = ctor.newInstance(o);
		return object;
	}



	public getSubEditor(String editor){
		return editorMap.get(editor);
	}
}
