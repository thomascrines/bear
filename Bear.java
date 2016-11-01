import java.util.*;

public class Bear implements Hibernatable{

  private String name;
  private ArrayList<Edible> belly;
  private boolean hibernating;

  public Bear(String name){
    this.name = name;
    this.belly = new ArrayList<Edible>();
    this.hibernating = false;
  }

  public String getName(){
    return this.name;
  }

  public int foodCount(){
    return this.belly.size();
  }

  public void eat(Edible food){
    this.belly.add(food);
  }

  public void sleep(){
   this.belly.clear();
 }

 public Edible throwUp() {
  if (foodCount() > 0) {
    return belly.remove(0);
  }
  return null;
}

public int totalNutrition(){
  int counter = 0;
  for ( Edible food : belly ) {
   counter += food.nutritionalValue();
 }
 return counter;
}

public void hibernate(){
  this.hibernating = true;
}

public boolean hibernating(){
  return this.hibernating;
}

}

