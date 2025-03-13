package etc.stream;

public class DishDetail {
    private final String name;
    private final String type;

    public DishDetail(Dish d) {
        this.name = d.getName();
        this.type = d.getType().getDesc();
    }



    @Override
    public String toString() {
        return "DishDetail{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
