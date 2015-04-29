//Another Concrete Decorator

public class SGDDecorator extends Decorator{
 Currency currency;

 public SGDDecorator(Currency currency){
  this.currency = currency;
 }


 public String getCurrencyDescription(){
  return currency.getCurrencyDescription()+" ,its singapore Dollar";
 }


@Override
public double cost(double value) {
	// TODO Auto-generated method stub
	return value;
}

}