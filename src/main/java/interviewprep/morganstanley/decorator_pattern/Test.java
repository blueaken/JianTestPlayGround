package interviewprep.morganstanley.decorator_pattern;

/**
 * @author jianshen
 */
public class Test {
    public static void main(String[] args){
        Coffee coffee = new SimpleCoffee();
        System.out.println("Ingredient: " + coffee.getIngredients() + " and cost is: " + coffee.getCost());

        coffee = new Milk(coffee);
        System.out.println("Ingredient: " + coffee.getIngredients() + " and cost is: " + coffee.getCost());

        coffee = new Whip(coffee);
        System.out.println("Ingredient: " + coffee.getIngredients() + " and cost is: " + coffee.getCost());

        //how about double milk?
        coffee = new Milk(coffee);
        System.out.println("Ingredient: " + coffee.getIngredients() + " and cost is: " + coffee.getCost());
    }
}
