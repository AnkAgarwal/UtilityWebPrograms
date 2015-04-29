
// Component on Decorator design pattern

public abstract class Currency {
 String description = "Unknown currency";

 public String getCurrencyDescription() {
  return description;
 }

 public abstract double cost(double value);

}









