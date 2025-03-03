package oop.Quiz_inter.Quiz_02;

// 서브 클래스 Memory
class Memory extends ComputerPart {

    public Memory(String partName, int partPrice) {
        super(partName, partPrice);
    }

    @Override
    public void describePart() {
        System.out.println("Memory: " + partName + ", Price: " + partPrice);
    }
}