package etc.lambda;

public class ApplePredict implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() <= 100;
    }
}
