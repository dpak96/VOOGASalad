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

	public callEditor(String editor, String method, param1){
		return myEditorMap.get(editor)."$method"(param1);

	}

	public callEditor(String editor, String method, param1,param2){
		return myEditorMap.get(editor)."$method"(param1,param2);
	}

	public callEditor(String editor, String method, param1,param2,param3){
		return myEditorMap.get(editor)."$method"(param1,param2,param3);
	}

	public callEditor(String editor, String method, param1,param2,param3,param4){
		return myEditorMap.get(editor)."$method"(param1,param2,param3,param4);
	}

}
