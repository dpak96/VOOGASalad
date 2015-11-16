package voogasalad_SquirtleSquad;

import javafx.scene.Node;
import model.Article;


public interface IAuthoringController {

    /*
     * Given a selected object, change its property
     */
    public void setProperty (Node obj);

    /*
     * Place an object from the palette onto the screen and reflect it in
     * the model
     */
    public void placeObject (double x, double y, Article placedObject);

    /*
     * Assign an action to a control
     */
    public void setControl (/* Map<KeyPress, Action> */);

    /*
     * Sets the introductory splash screen
     */
    public void setSplash ();

    /*
     * Loads another level
     */
    public void loadLevel ();

}
