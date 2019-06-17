package trelloTest.api.model;

public class CheckList {
    public CheckList(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public CheckList() {}

    public String name;
    public String id;

    @Override
    public String toString() {
        return "Cards{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
