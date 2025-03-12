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

    }
}
