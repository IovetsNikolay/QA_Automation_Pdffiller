package trelloTest.api.model;

import com.google.gson.annotations.SerializedName;

public class Cards {

    public Cards(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public Cards() {}

    //    @SerializedName("1-DESC_#(%%%")
    public String name;
    public String id;
    public String desc;

    @Override
    public String toString() {
        return "Cards{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
