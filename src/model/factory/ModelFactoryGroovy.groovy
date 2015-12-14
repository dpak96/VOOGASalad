package model.factory

import java.lang.reflect.Constructor

class ModelFactoryGroovy {
	public createNew(String name){
		Class<?> cl = Class.forName(name);
		Object object;
		Constructor<?> ctor = null;
		if(name.equals("authoring.controller.OtherController") || cName.equals("authoring.controller.KeyPressController") || cName.equals("authoring.controller.InfiniteController")){
			Class[] hi = new Class[2];
			hi[0] = AuthoringController.class;
			hi[1] = ModelController.class;
			ctor = cl.getConstructor(hi);
			Object[] o = new Object[2];
			o[0] = this;
			o[1] = myModelController;
			object = ctor.newInstance(o);
		}
		else if(cName.equals("authoring.controller.ArticleCAndGController")){
			Class[] hi = new Class[2];
			hi[0] = AuthoringController.class;
			hi[1] = EditorManager.class;
			ctor = cl.getConstructor(hi);
			Object[] o = new Object[2];
			o[0] = this;
			o[1] = myEditor;
			object = ctor.newInstance(o);
		}

		else{
			ctor = cl.getConstructor(AuthoringController.class);
			Object[] o = new Object[1];
			o[0] = this;
			object = ctor.newInstance(o);
		}

		return object;
	}
}
