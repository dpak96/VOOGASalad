package authoring.backend

import model.article.Article

import java.lang.reflect.Method


class PropertyEditor {


    public editProperty(String function,x, Article article) {
        article."$function"(x);
    }



}
