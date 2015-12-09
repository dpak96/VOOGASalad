package authoring.controller

import authoring.ui.editingmenus.ArticlePropertyEditorMenu
import imageeditor.ImageExtender
import javafx.scene.image.Image
import javafx.scene.input.TransferMode
import model.article.Article
import model.controller.ModelController


class InfiniteController {

    private AuthoringController myAuthoringController;
    private ModelController myModelController;
    private Map<Article,Double> randomGenMap;
    private List<List<Article>> constantGen;
    private List<Article> tempList;
    private Article currentArticle;
    private List<Article> articleList;

    public InfiniteController(AuthoringController ac){
        myAuthoringController = ac;
        //myModelController = mc;
        randomGenMap = new HashMap<>();
        constantGen = new ArrayList<>();
        tempList = new ArrayList<>();
        articleList = new ArrayList<>();
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

    public makeArticle(e){
        println("po")
        String image = e.getGestureSource().getImageName();
        currentArticle = new Article(image,0,0,true);
        articleList.add(currentArticle);
        //makePopup(currentArticle);
        ImageExtender dog = new ImageExtender();
        Image im = dog.extendImage(image,currentArticle.getWidth(),currentArticle.getHeight());
        //return im;
    }

    public void dragOn(event){
        if (event.getGestureSource() != this && event.getDragboard().hasImage()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            //println("yo");
        }

        event.consume();
    }

    public void makePopup(Article selectedArticle){
        ArticlePropertyEditorMenu menu = new ArticlePropertyEditorMenu("Hi",selectedArticle,myAuthoringController);
    }

}
