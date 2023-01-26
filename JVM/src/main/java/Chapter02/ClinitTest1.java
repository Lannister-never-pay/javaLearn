package Chapter02;

/**
 * @author lannisite
 * @program ClinitTest1
 * @description 描述
 * @date 2022/12/14 11:45
 */

public class ClinitTest1 {

    static class Father{
        public static  int  A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Son.B);  //  2
    }

}
