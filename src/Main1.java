import java.util.Scanner;

public class Main1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String unwangdulize(String word) {
        String preWord;
        if (word.startsWith("anti")) {
            preWord = "against ";
            word = word.substring(4);
            String s = unwangdulize(word);
            word = preWord + s;
        } else if (word.startsWith("post")) {
            preWord = "after ";
            word = word.substring(4);
            String s = unwangdulize(word);
            word = preWord + s;
        } else if (word.startsWith("pre")) {
            preWord = "before ";
            word = word.substring(3);
            String s = unwangdulize(word);
            word = preWord + s;
        } else if (word.startsWith("re")) {
            preWord = " again";
            word = word.substring(2);
            String s = unwangdulize(word);
            word = s + preWord;
        } else if (word.startsWith("un")) {
            preWord = "not ";
            word = word.substring(2);
            String s = unwangdulize(word);
            word = preWord + s;
        } else {
            if (word.endsWith("er")) {
                word = unwangdulize(word.substring(0, word.length() - 2));
                word = "one who " + word + "s";
            } else if (word.endsWith("ing")) {
                word = unwangdulize(word.substring(0, word.length() - 3));
                word = "to activity " + word;
            } else if (word.endsWith("ize")) {
                word = unwangdulize(word.substring(0, word.length() - 3));
                word = "change into " + word;
            } else if (word.endsWith("tion")) {
                word = unwangdulize(word.substring(0, word.length() - 4));
                word = "the process of " + word + "ing";
            } else if (word.endsWith("ful")) {
                unwangdulize(word.substring(0, word.length() - 3));
                word = "full of " + word;
            }
        }
        return word;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _word;
        try {
            _word = in.nextLine();
        } catch (Exception e) {
            _word = null;
        }

        res = unwangdulize(_word);
        System.out.println(res);
    }
}
