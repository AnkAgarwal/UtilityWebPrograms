// Concrete Decorator

public class USDDecorator extends Decorator{

 Currency currency;
 

 public USDDecorator(Currency currency){
  this.currency = currency;
 }


 public String getCurrencyDescription(){
  return currency.getCurrencyDescription()+" ,its US Dollar";
 }


@Override
public double cost(double value) {
	// TODO Auto-generated method stub
	return value;
}


}

