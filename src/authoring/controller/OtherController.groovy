package authoring.controller

import javafx.scene.control.Button
import javafx.scene.layout.Pane
import model.Event
import model.article.Article
import model.controller.ModelController
import model.processes.Condition
import model.processes.Executable

class OtherController {

    private ModelController myModelController;
    private AuthoringController myAuthoringController;
    public OtherController(AuthoringController ac,ModelController mc){
        myModelController = mc;
        myAuthoringController = ac;
    }

    public Map<String, Class<?>> getFactoryParameters(String s) {
        return myModelController.getParameters(s);
    }

    public Executable makeExecutable(String s, Map<String, Object> map) {
        return myModelController.createExecutable(s, map);
    }

    public Condition makeCondition(String s, Map<String, Object> map) {
        return myModelController.createCondition(s, map);
    }

    public Event makeEvent(String s, List<Condition> lc, List<Executable> le) {
        return myModelController.createEvent(s, lc, le);
    }

    public void mapKey(String button, List<Event> events) {
        myModelController.remapButton(button, events);
    }

    public List<Event> getEventList() {
        return this.myModelController.getAllEvents();
    }

    public Condition createCondition(String condName, Map<String,Object> params){
        this.myModelController.createCondition(condName,params);

    }

    public Executable createExecutable(String execName,Map<String,Object> params){
        this.myModelController.createExecutable(execName,params);
    }

    public Article getArticleFromCoordinates(double x, double y) {
        try {
            return myModelController.getArticleFromCoordinates(x, y);
        } catch (Exception e) {
            System.out.println("oops");
            return null;
        }
    }

    public List<String> getCollisionTypes(){
        return myModelController.getAllCollisionTypes();
    }
    public addEventToModel(Event eventToAdd,String eventType, Map<String,String> eventParameters){
        this.myModelController.addEvent(eventToAdd);
        if(eventType.equals("Active"))
            this.myModelController.addActiveEvent(eventToAdd);

        if(eventType.equals("Collision"))
            this.myModelController.addCollision(eventParameters.get("direction"),eventParameters.get("nameOne"),eventParameters.get("nameTwo"), eventToAdd);

        if(eventType.equals("Button"))
            this.myModelController.remapButton(eventParameters.get("button"), eventToAdd);


    }

    public deleteArticle(Article n){
        modelController.removeArticle(n);
        Button b = authoringController.getCurrentButton();
        Pane p = (Pane) b.getParent();
        p.getChildren().remove(b);
        authoringController.setHighlighted(false);
        authoringController.setCurrentButton(null);
    }

    public getViewPoint(){
        modelController.getViewpoint();
    }

}
