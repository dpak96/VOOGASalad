package model.controller;

import gameengine.*;
import java.util.*;
import javafx.stage.Window;
import model.*;
import model.XMLutility.xmlUtility;
import model.factory.*;
import resourcemanager.ResourceManager;


public class ModelController implements IModelController {
  private Model myModel;
  private ModelFactory myModelFactory;
  private xmlUtility myXMLUtility;
  private AddCollisionType addCollision;
  // WILL ADD CREATES FOR EVENTS AND STUFF AFTER WE DECIDE ON HOW TO PASS PARAMETERS

  public ModelController(Model model) {
    myModel = model;
    myModel.initialize();
    myModelFactory = new ModelFactory();
    myXMLUtility = new xmlUtility(myModel);
  }

  public Map<String, Class<?>> getParameters(String className) {
    return myModelFactory.getParameters(className);
  }

  public Article createArticle(String fileName,
                               double x,
                               double y,
                               boolean direction,
                               List<Event> events) {
    Article myViewpoint = myModel.getViewpoint();
    double xAdjusted = x + myViewpoint.getX();
    double yAdjusted = y + myViewpoint.getY();
    Article newArticle =
        myModelFactory.createArticle(fileName, xAdjusted, yAdjusted, direction, events);
    addArticle(newArticle);
    return newArticle;
  }

  public Article createArticle(String fileName, double x, double y, boolean direction) {
    Article newArticle = myModelFactory.createArticle(fileName, x, y, direction);
    addArticle(newArticle);
    return newArticle;
  }

  public Executable createExecutable(String executableName, Map<String, Object> data) {
    Executable newExecutable = myModelFactory.createExecutable(executableName, data);
    addExecutable(newExecutable);
    return newExecutable;
  }

  public Condition createCondition(String conditionName, Map<String, Object> data) {
    Condition newCondition = myModelFactory.createCondition(conditionName, data);
    addCondition(newCondition);
    return newCondition;
  }

  public Event createEvent(String name, List<Condition> conditions, List<Executable> executables) {
    Event newEvent = myModelFactory.createEvent(name, conditions, executables);
    addEvent(newEvent);
    return newEvent;
  }

  public void addEvent(Event newEvent) {
    myModel.addEvent(newEvent);
  }

  public void removeEvent(Event event) {
    myModel.removeEvent(event);
  }

  @Override
  public List<Event> getEvents() {
    return myModel.getEvents();
  }

  public List<Article> getArticles() {
    return myModel.getArticles();
  }

  public void addExecutable(Executable executable) {
    myModel.addExecutable(executable);
  }

  public void removeExecutable(Executable executable) {
    myModel.removeExecutable(executable);
  }

  public void addCondition(Condition condition) {
    myModel.addCondition(condition);
  }

  public void removeCondition(Condition condition) {
    myModel.removeCondition(condition);
  }

  @Override
  public void addArticle(Article article) {
    myModel.addArticle(article);
  }

  @Override
  public void removeArticle(Article article) {
    myModel.removeArticle(article);
  }

  @Override
  public void remapButton(String button, List<Event> events) {
    myModel.remapButton(button, events);
  }

  @Override
  public List<Event> getButtonEvents(String button) {
    return myModel.getButtonEvents(button);
  }

  public Article getCharacter() {
    return myModel.getCharacter();
  }

  public void setCharacter(Article character) {
    myModel.setCharacter(character);
  }

  public Article getViewpoint() {
    return myModel.getViewpoint();
  }

  public void setViewpoint(Article viewpoint) {
    myModel.setViewpoint(viewpoint);
  }

  public void addButtonMap(Map<String, List<Event>> buttonMap) {
    myModel.addAllButtonMap(buttonMap);
  }

  public Article getArticleFromCoordinates(double x, double y) {
    return myModel.getArticleFromCoordinates(x, y);
  }

  public void notifyObservers() {
    myModel.notifyObservers();
  }

  public void loadFromFile(Model toLoad) {
    myModel.destroyModel();
    myModel.initialize();
    myModel.addAllArticles(toLoad.getArticles());
    myModel.addAllEvents(toLoad.getEvents());
    myModel.addAllButtonMap(toLoad.getButtonMap());
    myModel.addAllConditions(toLoad.getConditions());
    myModel.addAllExecutables(toLoad.getExecutables());
    myModel.setCharacter(toLoad.getCharacter());
  }

  public void save(Window wind) {
    myXMLUtility.saveModel(wind);
  }

  public void load(Window wind) {
    loadFromFile(myXMLUtility.loadModel(wind));
  }

  public void addCollisionType(String name) {
    addCollision = new AddCollisionType(name);
    addCollision.add();
  }
  
  public void addCollisionType(String name, String one, String two, String collision, Double type) {
    addCollision = new AddCollisionType(name);
    addCollision.add();
    addCollision.define(one, two, collision, type);
  }
  
  public void setBackgroundImage(String name){
    myModel.setBackgroundImage(name);
  }
  

}
