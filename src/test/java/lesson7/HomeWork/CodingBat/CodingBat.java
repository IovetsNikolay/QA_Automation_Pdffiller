package lesson7.HomeWork.CodingBat;

public class CodingBat {

    public String makeOutWorld (String out, String word) {

        return (out.substring(0, 2) + word + out.substring(2));

    }

    public String extraEnd (String str) {
        if (str.length() < 2) {
            return "Incorrect String";
        }
        return (str.substring(str.length()-2) + str.substring(str.length()-2) + str.substring(str.length()-2));
    }

    public String firstTwo (String str) {
        if (str.length() < 2) {
            return str;
        }
        return str.substring(0, 2);
    }

    public String firstHalf (String str) {
        return str.substring(0, str.length()/2);
    }

    public String withOutEnd (String str) {
        return str.substring(1, str.length()-1);
    }

    public String comboString (String a, String b) {
        if (a.length() < b.length()) {
            return (a + b + a);
        } else {
            return (b + a + b);
        }
    }

    public String nonStart (String a, String b) {
        return a.substring(1) + b.substring(1);
    }

    public String left2 (String str) {
        return str.substring(2) + str.substring(0, 2);
    }

    public String right2 (String str) {
        return str.substring(str.length()-2) + str.substring(0, str.length()-2);
    }

    public String theEnd (String str, boolean front) {
        if (front) {
            return str.substring(0, 1);
        } else {
            return str.substring(str.length()-1);
        }
    }

    public String withouEnd2 (String str) {
        if (str.length() > 2) {
            return str.substring(1, str.length() - 1);
        } else {
            return "";
        }
    }

    public String middleTwo (String str) {
        return str.substring((str.length()/2-1), str.length()/2+1);
    }

    public boolean endsLy (String str) {
        if (str.length() < 2 || !(str.substring(str.length()-2).equals("ly"))) {
            return false;
        } else {
            return true;
        }
    }

    public String nTwice (String str, int n) {
        return (str.substring(0, n) + str.substring(str.length()-n));
    }

    public String twoChar (String str, int index) {
        if (index < 0 || !(index <= (str.length()-2))) {
            return str.substring(0, 2);
        } else {
            return str.substring(index, index+2);
        }
    }

    public String middleThree (String str) {
        return str.substring(str.length()/2-1, str.length()/2+2);
    }

    public boolean hasBad (String str) {
        if (str.indexOf("bad") == 0 || str.indexOf("bad") == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String atFirst (String str) {
        if (str.length() == 0) {
            return "@@";
        } else if (str.length() == 1) {
            return str + "@";
        } else {
            return str.substring(0, 2);
        }
    }

    public String lastChars (String a, String b) {
        if (a.length() == 0) {
            a = "@";
        }
        if (b.length() == 0) {
            b = "@";
        }
        return a.substring(0, 1) + b.substring(b.length()-1);
    }

    public String conCat (String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return a + b;
        }
        else if ((a.charAt(a.length()-1) == b.charAt(0))) {
            return a.substring(0, a.length()-1) + b;
        } else return a + b;
    }

    public String lastTwo (String str) {
        if (str.length() >= 2) {
            return str.substring(0, str.length()-2) + str.charAt(str.length()-1) + str.charAt(str.length()-2);
        } else {
            return str;
        }
    }

    public String seeColour (String str) {
        if (str.indexOf("red") == 0) {
            return str.substring(0, 3);
        }
        else if (str.indexOf("blue") == 0) {
            return str.substring(0,4);
        } else {
            return "";
        }
    }

    public boolean frontAgain (String str) {
        if (str.length() < 2) {
            return false;
        } else if (str.substring(0, 2).equals(str.substring(str.length()-2))) {
            return true;
        } else {
            return false;
        }
    }

    public String minCat (String a, String b) {
        if (a.length() == b.length()) {
            return a + b;
        } else if (a.length() > b.length()) {
            return a.substring(a.length() - b.length()) + b;
        } else
            return a + b.substring(b.length() - a.length());
    }

    public String extraFront (String str) {
        if (str.length() <= 2) {
            return str + str + str;
        } else {
            return str.substring(0, 2) + str.substring(0, 2) + str.substring(0, 2);
        }
    }

    public String without2 (String str) {
        if (str.length() < 2 || !(str.substring(0, 2).equals(str.substring(str.length()-2)))) {
            return str;
        } else {
            return str.substring(2);
        }
    }

    public String deFront (String str) {
        if (str.length() == 0) {
            return str;
        } else if (str.length() == 1) {
            if (str.charAt(0) == 'a') {
                return str.substring(0, 1);
            } else {
                return "";
            }
        } else {
            if (str.charAt(0) == 'a' && str.charAt(1) == 'b') {
                return str;
            } else if (str.charAt(0) == 'a') {
                return str.substring(0, 1) + str.substring(2);
            } else if (str.charAt(1) == 'b') {
                return str.substring(1);
            } else {
                return str.substring(2);
            }
        }
    }

    public String startWord (String str, String word) {
        if ((word.length() == 0) || !(str.substring(1).indexOf(word.substring(1)) == 0) || str.length() == 0) {
            return "";
        } else if (word.length() == 1) {
            return str.substring(0, 1);
        } else {
            return str.substring(0, word.length());
        }
    }

    public String withoutX (String str){
        if (str.length() == 0 || (str.length() == 1 && str.charAt(0) == 'x')) {
            return "";
        } if (str.charAt(0) == 'x') {
            str = str.substring(1);
        }
        if (str.charAt(str.length()-1) == 'x') {
           str =  str.substring(0, str.length()-1);
        }
        return str;
    }

    public String withoutX2 (String str) {
        if (str.length() == 0 || (str.length() == 1 && str.charAt(0) == 'x')) {
            return "";
        }else if (str.charAt(0) == 'x' || str.charAt(1) == 'x') {
            return (str.substring(0, 2).replace("x", "") + str.substring(2));
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        CodingBat obj1 = new CodingBat();
//        System.out.println(obj1.makeOutWorld("<<>>", "Yay"));
//        System.out.println(obj1.extraEnd("abhhab"));
//        System.out.println(obj1.firstTwo("jj"));
//        System.out.println(obj1.firstHalf("highgkij"));
//        System.out.println(obj1.withOutEnd("Hello"));
//        System.out.println(obj1.comboString("aaa", "bb"));
//        System.out.println(obj1.nonStart("Hello", "Kool"));
//        System.out.println(obj1.left2("He"));
//        System.out.println(obj1.right2("He"));
//        System.out.println(obj1.theEnd("Hello", false));
//        System.out.println(obj1.withouEnd2("Hel"));
//        System.out.println(obj1.middleTwo("aaammm"));
//        System.out.println(obj1.endsLy(""));
//        System.out.println(obj1.nTwice("Hello", 2));
//        System.out.println(obj1.twoChar("Hello", 3));
//        System.out.println(obj1.middleThree("anda"));
//        System.out.println(obj1.hasBad("ba"));
//        System.out.println(obj1.atFirst("jhllhllhlhljlj"));
//        System.out.println(obj1.lastChars("b", ""));
//        System.out.println(obj1.conCat("", ""));
//        System.out.println(obj1.lastTwo(""));
//        System.out.println(obj1.seeColour("bluu"));
//        System.out.println(obj1.frontAgain("hj"));
//        System.out.println(obj1.minCat("ello", "Heloo"));
//        System.out.println(obj1.extraFront(""));
        System.out.println(obj1.without2("Hi"));
//        System.out.println(obj1.deFront("gbnju"));
//        System.out.println(obj1.startWord("hippo", "iipp"));
//        System.out.println(obj1.withoutX("xfsdsdfx"));
//        System.out.println(obj1.withoutX2("xxxix"));
    }
}