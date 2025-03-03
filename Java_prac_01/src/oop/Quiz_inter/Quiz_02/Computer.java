package oop.Quiz_inter.Quiz_02;

public class Computer {
    private ComputerPart[] parts;

    public Computer() {
        this.parts = new ComputerPart[0];
    }

    public void addPart(ComputerPart part) {
        // ComputerPart[] 에 부품 추가
        ComputerPart[] tmp = new ComputerPart[parts.length + 1];
        for (int i = 0; i < parts.length; i++) {
            tmp[i] = parts[i];
        }
        tmp[parts.length] = part;
        parts = tmp;
    }

    public void showParts() {
        // 모든 부품 정보 출력
        for (ComputerPart part : parts) {
            part.describePart();
        }
    }
}
