package etc.stream;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type; // 요리 카테고리


    public enum Type{
        MEAT("육류"),
        FISH("어류"),
        OTHER("기타");

        private final String desc;

        Type(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    public Dish(String name, boolean vegeterian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegeterian;
        this.calories = calories;
        this.type = type;
    }

    public boolean isVegetarian(){
        return this.vegetarian;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegeterian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
