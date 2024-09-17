import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilteringApplesTest {
    List<FilteringApples.Apple> inventory = Arrays.asList(
            new FilteringApples.Apple(80, "green"),
            new FilteringApples.Apple(155, "green"),
            new FilteringApples.Apple(120, "red")
    );

    List<FilteringApples.Apple> greenApples = Arrays.asList(
            new FilteringApples.Apple(80, "green"),
            new FilteringApples.Apple(155, "green")
    );

    List<FilteringApples.Apple> heavyApples = List.of(
            new FilteringApples.Apple(155, "green")
    );


    @BeforeEach
    void setUp() {
        FilteringApples fa = new FilteringApples();
        fa.main([""]);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main(String[]s) {

    }

    @Test
    void filterGreenApples() {
        //assertEquals(greenApples.toArray(),FilteringApples.filterApples(this.inventory, FilteringApples::isGreenApple).toArray());
        assertEquals(greenApples.get(0).toString(), FilteringApples.filterApples(this.inventory, FilteringApples::isGreenApple).get(0).toString());
        //Assertions.assertIterableEquals(greenApples,FilteringApples.filterApples(this.inventory, FilteringApples::isGreenApple));

        //Assertions
    }

    @Test
    void filterHeavyApples() {
        assertEquals(heavyApples.get(0).toString(),FilteringApples.filterApples(this.inventory, FilteringApples::isHeavyApple).get(0).toString());
    }

    @Test
    void isGreenApple() {
        FilteringApples.Apple a1 = new FilteringApples.Apple(1,"green");
        FilteringApples.Apple a2 = new FilteringApples.Apple(1,"red");

        assertTrue(FilteringApples.isGreenApple(a1));
        assertFalse(FilteringApples.isGreenApple(a2));
    }

    @Test
    void isHeavyApple() {
        FilteringApples.Apple a1 = new FilteringApples.Apple(151,"green");
        FilteringApples.Apple a2 = new FilteringApples.Apple(149,"red");

        assertTrue(FilteringApples.isHeavyApple(a1));
        assertFalse(FilteringApples.isHeavyApple(a2));

    }

    @Test
    void filterApples() {
        assertEquals(heavyApples.get(0).toString(),FilteringApples.filterApples(inventory, (FilteringApples.Apple a) -> a.getWeight() > 150).get(0).toString());
    }
}