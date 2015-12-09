package authoring.controller.presets;

import authoring.controller.AuthoringController;
import model.controller.ModelController;

public class Preset {
	AuthoringController myAuthoringController;
	ModelController myModelController;
	public Preset(AuthoringController ac, ModelController mc){
		myAuthoringController = ac;
		myModelController = mc;
	}
}
