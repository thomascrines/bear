import static org.junit.Assert.*;
import org.junit.*;

public class BearTest{
  Bear bear;
  Salmon salmon;
  Human human;
  Chicken chicken;

  @Before 
  public void before() {
    bear = new Bear("Baloo");
    salmon = new Salmon(); 
    human = new Human();
    chicken = new Chicken();
  }

  @Test
  public void hasName(){
    assertEquals( "Baloo", bear.getName() ); 
  }

  @Test
  public void bellyStartsEmpty(){
    assertEquals(0, bear.foodCount());
  }

  @Test
  public void canEatSalmon(){
    bear.eat(salmon);
    assertEquals(1, bear.foodCount());
  }

    @Test
  public void canEatHuman(){
    bear.eat(human);
    assertEquals(1, bear.foodCount());
  }

  @Test
  public void canEatBoth(){
    bear.eat(human);
    bear.eat(salmon);
    assertEquals(2, bear.foodCount());
  }

  @Test
  public void shouldEmptyBellyAfterSleeping(){
    bear.eat(salmon);
    bear.eat(human);
    bear.eat(chicken);
    bear.sleep();
    assertEquals(bear.foodCount(), 0);
  }

  @Test
  public void canThrowUp(){
    bear.eat(salmon);
    Edible food = bear.throwUp();
    assertNotNull(food);
  }

  @Test
  public void canGetSalmonBack(){
    bear.eat(salmon);
    Edible food = bear.throwUp();
    Salmon original = (Salmon) food;
    assertEquals("swimming", original.swim());
  }

    @Test
  public void canGetChickenBack(){
    bear.eat(chicken);
    Edible food = bear.throwUp();
    Chicken original = (Chicken) food;
    assertEquals("cluck cluck clucking", original.cluck());
  }

  @Test
  public void chickenHasNutritionalValue(){
    assertEquals(90, chicken.nutritionalValue());
  }

  @Test
  public void totalNutrition(){
    bear.eat(chicken);
    bear.eat(human);
    bear.eat(salmon);
    assertEquals(190, bear.totalNutrition());
  }

  @Test
  public void edibleCanSwim(){
    bear.eat(human);
    Edible food = bear.throwUp();
    assertEquals("swimming", food.swim());
  }

  @Test
  public void bearCanHibernate(){
    bear.hibernate();
    assertEquals(true, bear.hibernating());
  }

}
