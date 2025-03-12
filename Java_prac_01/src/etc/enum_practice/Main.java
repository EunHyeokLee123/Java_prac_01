package etc.enum_practice;

public class Main {
    public static void main(String[] args) {
        Developer kim = new Developer();
        kim.setName("김민우");
        kim.setCareer(3);
        kim.setLang(Language.JAVA);

        Developer park = new Developer();
        park.setName("박찬호");
        park.setCareer(6);
        park.setLang(Language.CPP);

        System.out.println(kim.getName() + "의 주력 언어는 "+
                kim.getLang());
        System.out.println(park.getName() + "의 주력 언어는 "+
                park.getLang());

        System.out.println(kim.getName() + "의 주력 언어는 컴파일 언어인가? "
        + kim.getLang().isCompileLang());
        System.out.println(park.getName() + "의 주력 언어는 컴파일 언어인가? "
                + park.getLang().isCompileLang());

        System.out.println("==================================");

        Language[] lan = Language.values();
        for (Language language : lan) {
            System.out.println(language);
        }

        // ordinal() : 열거형 타입에 열거되어 있는 순서를 정수값으로 리턴
        System.out.println(park.getLang().ordinal());

        // valueOf("str") : 매개값으로 전달된 문자열과 일치하는 요소를 리턴
        System.out.println(Language.valueOf("CPP"));

    }
}
