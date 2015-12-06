package model.controller;

import gameengine.*;

import java.io.File;
import java.util.*;

import javafx.stage.Window;
import level.manager.LevelManager;
import model.*;
import model.XMLutility.xmlUtility;
import model.article.Article;
import model.factory.*;
import model.processes.Condition;
import model.processes.Executable;
import resourcemanager.ResourceManager;
import startscreen.GameCreation;


public class ModelController implements IModelController {
  private Model myModel;
  private ModelFactory myModelFactory;
  private xmlUtility myXMLUtility;
  private AddCollisionType addCollision;
  private LevelManager myLevelManager;
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

  public void makeLevelManager(GameCreation game) {
	  myLevelManager = new LevelManager(game);
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
    return myModel.getAllEvents();
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
    myModel.addAllEvents(toLoad.getAllEvents());
    myModel.addAllButtonMap(toLoad.getButtonMap());
    myModel.addAllConditions(toLoad.getConditions());
    myModel.addAllExecutables(toLoad.getExecutables());
    myModel.setCharacter(toLoad.getCharacter());
    toLoad.destroyModel();
  }

  public void save(Window wind, String path) {
    myXMLUtility.saveModel(wind, path);
  }

  public void load(Window wind) {
    loadFromFile(myXMLUtility.loadModel(wind));
  }
  public void load(File file){
	  loadFromFile(myXMLUtility.load(file));
  }

//  public void addCollisionType(String name) {
//    addCollision = new AddCollisionType(name);
//    addCollision.add();
//  }
  
//  public void addCollisionType(String name, String one, String two, String collision, Double type) {
//    addCollision = new AddCollisionType(name);
//    addCollision.add();
//    addCollision.define(one, two, collision, type);
//  }
  
  public void addNewCollisionType(String type){
		myModel.addNewCollisionType(type);
  }
	
  public void addCollision(String direction, String nameOne, String nameTwo, Event event){
		myModel.addCollision(direction, nameOne, nameTwo, event);
  }
  
  public void initializeCollision(){
	  myModel.initializeCollision();
  }
	
  public List<Event> getCollisionEvents(String direction, String nameOne, String nameTwo){
		return myModel.getCollisionEvents(direction, nameOne, nameTwo);
  }
  
  public void setBackgroundImage(String name){
    myModel.setBackgroundImage(name);
  }
  
  public void setModel(Model model) {
	  this.myModel = model;
  }
  
  public List<Event> getActiveEvents(){
	  return myModel.getActiveEvents();
  }
  
  public void addActiveEvent(Event event){
	  myModel.addActiveEvent(event);
  }
  
  public void removeExecutableFromEvent(Event event, Executable exec){
	  myModel.removeExecutableFromEvent(event, exec);
  }
  
  public void removeConditionFromEvent(Event event, Condition cond){
	  myModel.removeConditionFromEvent(event, cond);
  }
  
  public List<Event> getAllEvents(){
	  return myModel.getAllEvents();
  }
  
}
