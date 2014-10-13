package controllers;


import models.Person;
import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready Testing..."));

    }

    public static Result addPerson() {
        Person  person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.Application.index());
    }

    public static Result gerPersons(){
        List<Person> persons = new Model.Finder(String.class,Person.class).all();
        return ok(Json.toJson(persons));

    }

}
