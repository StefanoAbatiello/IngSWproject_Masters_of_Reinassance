package it.polimi.ingsw.messages;

import java.util.ArrayList;

public class ChangeChoosableResourceRequest implements SerializedMessage {

    private int num;
    private ArrayList<String> resources;
    private String message;

    public ChangeChoosableResourceRequest(int num, ArrayList<String>resources,String message) {
        this.num=num;
        this.resources=resources;
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<String> getResources() {
        return resources;
    }

    public int getNum() {
        return num;
    }
}
