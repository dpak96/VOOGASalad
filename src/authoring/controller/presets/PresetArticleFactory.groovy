/*
 *  NOTE: THIS CLASS IS MEANT TO HELP US SAVE TIME ON THE DEMO.
 *  
 *  I am aware there is a lot of duplicated code, but it is meant to attach as a module onto the authoring controller
 *  
 *  Each line of code is meant to replace a user function on the front end!!
 *  
 *  In this way we are allowed to keep the massive amount of flexibility but to save user time
 * 
 */

package authoring.controller.presets;

import authoring.controller.AuthoringController
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Event;
import model.article.Article;
import model.controller.ModelController;
import model.processes.Condition;
import model.processes.Executable;

public class PresetArticleFactory {
	private ModelController myModelController;
	private AuthoringController myAuthoringController;

	private PlatformPreset myPlatform;
	private GoombaPreset myGoomba;
	private VegetaPreset myVegeta;

	public PresetArticleFactory(ModelController mc, AuthoringController ac) {
		myModelController = mc;
		myAuthoringController = ac;
		myPlatform = new PlatformPreset(ac, mc);
		myGoomba = new GoombaPreset(ac, mc);
		myVegeta = new VegetaPreset(ac, mc);
	}

	public void platformMovement(Article article) {
		myPlatform.platformMovement(article);
	}

	public void goombaMovement(Article article) {
		myGoomba.goombaMovement(article);
	}

	public void noClipMovement(Article article) {
		myVegeta.noClipMovement(article);
	}
}
