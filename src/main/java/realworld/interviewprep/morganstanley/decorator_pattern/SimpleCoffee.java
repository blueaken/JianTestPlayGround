package realworld.interviewprep.morganstanley.decorator_pattern;

/**
 * @author jianshen
 */
public class SimpleCoffee extends Coffee {

    public double getCost(){
        return 1.0;
    }

    public String getIngredients(){
        return "Coffee";
    }

}
