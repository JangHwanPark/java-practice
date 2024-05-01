public class ArrayExam {
    public String[][] strArr = {{"apple", "banana", "kiwi", "mango"}, {"test1", "test2", "test3"}, {"test4", "test5"
            , "test6"}};
    private int cnt = 0;
    public ArrayExam() {
        for (String[] i : strArr) {
            System.out.println(i[cnt++]);
        }
    }
    public static void main(String[] args) {
        new ArrayExam();
    }
}