package authoring.controller

import model.Event
import model.article.Article
import model.controller.ModelController
import model.processes.Condition
import model.processes.Executable

class OtherController {

    private ModelController modelController;
    public OtherController(ModelController mc){
        modelController = mc;
    }

    public Map<String, Class<?>> getFactoryParameters(String s) {
        return modelController.getParameters(s);
    }

    public Executable makeExecutable(String s, Map<String, Object> map) {
        return modelController.createExecutable(s, map);
    }

    public Condition makeCondition(String s, Map<String, Object> map) {
        return modelController.createCondition(s, map);
    }

    public Event makeEvent(String s, List<Condition> lc, List<Executable> le) {
        return modelController.createEvent(s, lc, le);
    }

    public void mapKey(String button, List<Event> events) {
        modelController.remapButton(button, events);
    }

    public List<Event> getEventList() {
        return this.modelController.getAllEvents();
    }

    public Condition createCondition(String condName, Map<String,Object> params){
        this.modelController.createCondition(condName,params);

    }

    public Executable createExecutable(String execName,Map<String,Object> params){
        this.modelController.createExecutable(execName,params);
    }

    public Article getArticleFromCoordinates(double x, double y) {
        try {
            return modelController.getArticleFromCoordinates(x, y);
        } catch (Exception e) {
            System.out.println("oops");
            return null;
        }
    }

    public List<String> getCollisionTypes(){
        return modelController.getAllCollisionTypes();
    }
    public addEventToModel(Event eventToAdd,String eventType, Map<String,String> eventParameters){
        this.modelController.addEvent(eventToAdd);
        if(eventType.equals("Active"))
            this.modelController.addActiveEvent(eventToAdd);

        if(eventType.equals("Collision"))
            this.modelController.addCollision(eventParameters.get("direction"),eventParameters.get("nameOne"),eventParameters.get("nameTwo"), eventToAdd);

        if(eventType.equals("Button"))
            this.modelController.remapButton(eventParameters.get("button"), eventToAdd);


    }


}
