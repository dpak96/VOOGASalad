package authoring.controller

import model.article.Article
import model.controller.ModelController


class InfiniteController {

    private AuthoringController myAuthoringController;
    private ModelController myModelController;
    private Map<Article,Double> randomGenMap;
    private List<List<Article>> constantGen;
    private List<Article> tempList;

    public InfiniteController(AuthoringController ac, ModelController mc){
        myAuthoringController = ac;
        myModelController = mc;
        randomGenMap = new HashMap<>();
        constantGen = new ArrayList<>();
        tempList = new ArrayList<>();
    }

    public addToRandom(Article n, double d){
        randomGenMap.put(n, d);
    }

    public getRandomMap(){
        return randomGenMap;
    }

    public addIndConstant(Article n){
        tempList.add(n);
    }

    public addSetToConstant(){
        constantGen.add(tempList);
        tempList = new ArrayList<>();
    }



    public addInfinite(){

    }

    public genInfinite(){

    }

    public genRandom(){
        randomGenMap = new HashMap<>();
    }

    public genConstant(){

        constantGen = new ArrayList<>();
    }

}
