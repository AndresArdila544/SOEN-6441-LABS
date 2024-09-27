import modernjavainaction.chap02.FilteringApples;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilteringApplesTest {

    List<FilteringApples.Apple> inventory = Arrays.asList(
            new FilteringApples.Apple(80, FilteringApples.Color.GREEN),
            new FilteringApples.Apple(155, FilteringApples.Color.GREEN),
            new FilteringApples.Apple(120, FilteringApples.Color.RED)
    );

    List<FilteringApples.Apple> greenApples = Arrays.asList(
            new FilteringApples.Apple(80, FilteringApples.Color.GREEN),
            new FilteringApples.Apple(155, FilteringApples.Color.GREEN)
    );

    List<FilteringApples.Apple> heavyApples = List.of(
            new FilteringApples.Apple(155, FilteringApples.Color.GREEN)
    );

    List<FilteringApples.Apple> redAndHeavyApples = List.of();

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void filterApplesByColor() {
        assertEquals(greenApples.get(0).toString(), FilteringApples.filter(this.inventory, new FilteringApples.AppleColorPredicate()).get(0).toString());
    }

    @org.junit.jupiter.api.Test
    void filterApplesByWeight() {
        assertEquals(heavyApples.get(0).toString(), FilteringApples.filter(this.inventory, new FilteringApples.AppleWeightPredicate()).get(0).toString());
    }

    @org.junit.jupiter.api.Test
    void filter() {
        assertEquals(redAndHeavyApples, FilteringApples.filter(this.inventory, new FilteringApples.AppleRedAndHeavyPredicate()));
    }
}