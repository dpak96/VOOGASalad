// This entire file is part of my masterpiece.
// Rob Martorano



package authoring.backend

import model.controller.ModelController;
import resourcemanager.ResourceManager

import java.lang.reflect.Constructor;


public class EditorManager extends Editor {
	private Map<String, Editor> myEditorMap;

	public EditorManager(ModelController modelController) {
		super(modelController);
		this.register(modelController);
	}

	private void register(ModelController mc){
		ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "Reflection");
		myEditorMap = new HashMap<String, Editor>();
		for(String x: rb.keySet()){
			myEditorMap.put(x, getNewInstance(rb.getString(x)));
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
		return myEditorMap.get(editor);
	}


	public callEvent(String editor, String method, e1){
		return myEditorMap.get(editor)."$method"(e1);

	}

	public callEvent(String editor, String method, e1,e2){
		return myEditorMap.get(editor)."$method"(e1,e2);
	}

	public callEvent(String editor, String method, e1,e2,e3){
		return myEditorMap.get(editor)."$method"(e1,e2,e3);
	}

	public callEvent(String editor, String method, e1,e2,e3,e4){
		return myEditorMap.get(editor)."$method"(e1,e2,e3,e4);
	}

}
