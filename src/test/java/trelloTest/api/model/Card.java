package trelloTest.api.model;

import com.google.gson.annotations.SerializedName;

public class Card {

    public Card(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public Card() {}

    //    @SerializedName("1-DESC_#(%%%")
    public String name;
    public String id;
    public String desc;

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
