package basic.casting;

public class CastEx {
    public static void main(String[] args) {

        char c1 = 'B';
        int i1 = 2;
        int i2 = c1+i1;
        // char + int 는 더 큰 int로 캐스팅됨
        char c2 = (char) (c1+i1);
        System.out.println("c2 = " + c2);
        System.out.println("i2 = " + i2);
        // 서로 다른 타입간의 연산은 작은 쪽이 큰 쪽을 따라감.

        // int와 int의 연산이므로 결과가 int로 나오게됨.
        int i3 = 10; double d1 = i3/4;
        // 결과가 2로 나오게됨
        System.out.println("d1 = " + d1);
        // i3나 4 중 하나라도 double로 캐스팅을 하면 2.5가 d1에 들어감.
    }
}
