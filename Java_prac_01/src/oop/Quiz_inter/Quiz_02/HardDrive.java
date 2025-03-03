package oop.Quiz_inter.Quiz_02;

// 서브 클래스 HardDrive
class HardDrive extends ComputerPart {

    public HardDrive(String partName, int partPrice) {
        super(partName, partPrice);
    }

    @Override
    public void describePart() {
        System.out.println("Hard Drive: " + partName + ", Price: " + partPrice);
    }
}