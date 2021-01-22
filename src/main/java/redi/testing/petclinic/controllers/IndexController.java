package redi.testing.petclinic.controllers;

public class IndexController {

    public String index(){
        return "index";
    }

    public String oupsHandler(){
        return "notimplemented";
    }

    public String oupsHandler_2() {
        throw new ValueNotFoundException();
    }
}
