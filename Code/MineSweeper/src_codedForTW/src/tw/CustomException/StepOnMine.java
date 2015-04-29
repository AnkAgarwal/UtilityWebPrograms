package src.tw.CustomException;



public class StepOnMine extends Exception
{
      //Parameterless Constructor
      public StepOnMine() {}

      //Constructor that accepts a message
      public StepOnMine(String message)
      {
         super(message);
      }
 }

