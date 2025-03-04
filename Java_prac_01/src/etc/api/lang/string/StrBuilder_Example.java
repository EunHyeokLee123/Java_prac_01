package etc.api.lang.string;

public class StrBuilder_Example {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str.hashCode());

        str = "Hello world!";
        System.out.println(str.hashCode());

        str = "Hello~!";
        System.out.println(str.hashCode());

        System.out.println("=========================");

        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb);
        System.out.println(sb.hashCode());

        // 문자열을 맨끝에 추가하는 메소드 : append
        sb.append(" world!");
        System.out.println(sb);
        System.out.println(sb.hashCode());

        // 문자열을 특정 인덱스 위치에 삽입하는 메소드
        // insert(인덱스, 문자열)
        sb.insert(5," 중간중간");
        System.out.println(sb);
        System.out.println(sb.hashCode());

        // 특정 인덱스 범위의 문자열을 교체하는 메소드
        // replace(begin, end, 문자열)
        sb.replace(6,11,"사이사이 ");
        System.out.println(sb);
        System.out.println(sb.hashCode());

        // 문자열 내의 특정 단어를 삭제하는 메소드
        // delete(begin, end)
        sb.delete(6,11);
        System.out.println(sb);
        System.out.println(sb.hashCode());

        // 문자열을 역순으로 배치
        // reverse()
        sb.reverse();
        System.out.println(sb);
        System.out.println(sb.hashCode());
    }
}
