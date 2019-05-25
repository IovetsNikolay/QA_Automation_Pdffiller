package SignNow;

import lesson7.ClassWork.Box;

public class ExceptionBox {

    static Box box;
    public static void makeSomeMagic() {
        if(box == null){
            throw new NullPointerException("BOX не инициализирован!");
        }
    }

    public static void procA() {
        try {
            System.out.println("inside procA");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("procA's finally");
        }
    }

    public static void main(String[] args) {
        procA();
    }

    public static String getSurname(String nameAndSurname){
        String surname = nameAndSurname.split(" ")[1];
        try {
            return surname;
        } finally {
            System.out.println(surname);
        }
    }

}
