package basic.datatype;

public class TextExample {
    public static void main(String[] args) {
        // '' 홑따옴표는 문자 하나만
        /*
         # 문자열을 저장할 수 있는 데이터 타입 String
         - 저장하고 싶은 문자열을 겹따옴표("")에 담아 대입합니다.
         - String은 기본 데이터 타입은 아니지만 자주 쓰이기 때문에
         기본 데이터 타입처럼 사용합니다. (사실은 객체 타입)
         */
        char ab = 'A';
        // char 문자표는 65536개의 문자를 표현
        char a1 = 44033;
        System.out.println("ab = " + ab);
        System.out.println("a1 = " + a1);


        // "" 쌍따옴표는 문자열 String으로 된다.
        String c1 = "이게 뭐랄까";
        String c2 = "이건 좀 신기하네";
        System.out.println("c1 = " + c1);
        // 문자열끼리 +하면 단순하게 이어짐
        System.out.println(c1 + c2);
        System.out.println(c2 + c1);
        int i1 = 100; String c3 = "100";
        System.out.println(c1+i1);
        System.out.println(i1+" "+c2);
        // String + int 은 전부 String으로 인식됨
        String re = c3+i1;
        System.out.println(c3+i1);
        System.out.println(re);

    }
}
