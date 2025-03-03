package oop.Quiz_inter.Quiz_02;

public class Processor extends ComputerPart{

    public Processor(String partName, int partPrice) {
        super(partName, partPrice);
    }

    @Override
    public void describePart() {
        System.out.println("Processor: " + partName + ", Price: " + partPrice);
    }
}
