package realworld.interviewprep.morganstanley.decorator_pattern;

/**
 * @author jianshen
 */

// Abstract decorator class - note that it extends Coffee abstract class
public abstract class CoffeeDecorator extends Coffee{
    protected Coffee decoratedCoffee;
    protected String separator = ",";

    protected CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    public double getCost() { // Implementing methods of the abstract class
        return decoratedCoffee.getCost();
    }

    public String getIngredients() {
        return decoratedCoffee.getIngredients();
    }
}

// Decorator Milk that mixes milk with coffee.
// Note it extends CoffeeDecorator.
class Milk extends CoffeeDecorator {
    public Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost(){
        return super.getCost() + 0.5;
    }

    public String getIngredients(){
        return super.getIngredients() + separator + " Milk";
    }
}

// Decorator Whip that mixes whip with coffee.
// Note it extends CoffeeDecorator.
class Whip extends CoffeeDecorator {
    public Whip(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost(){
        return super.getCost() + 0.7;
    }

    public String getIngredients(){
        return super.getIngredients() + separator + " Whip";
    }
}