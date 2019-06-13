package trelloTest.api.model;

import com.google.gson.annotations.SerializedName;

public class Card {
    public String id;
//    @SerializedName("1-DESC_#(%%%")
    public String desc;
    public String idBoard;
    public String idList;
    public String name;
    public String url;

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", idList='" + idList + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
