package trelloTest.api.model;

import java.util.ArrayList;
import java.util.List;

public class Card {

    //    @SerializedName("1-DESC_#(%%%")
    public String name;
    public String id;
    public String desc;
    public List<CardLabel> labels = new ArrayList<>();

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
