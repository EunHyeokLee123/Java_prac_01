package etc.generic.bad;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        Box box = new Box();
        Box box2 = new Box();

        box.setContent("김민철");
        String con1 = (String) box.getContent();
        // 문자열임에도 Object라서 메소드 사용불가.
        System.out.println(con1.charAt(0));

        /*
         Object타입으로 선언하면 무엇이든 저장할 수는 있지만
         반대로 저장했던 값을 꺼내올 때는 타입별로 일일히 형변환을 해야하는
         문제가 발생합니다.
         잘못 형 변환 했을 시에는 예외가 발생할 수도 있습니다.
         */

        p1.setName("문동주");
        box2.setContent(p1);
        System.out.println(((Person)(box2.getContent())).getName());

    }
}
