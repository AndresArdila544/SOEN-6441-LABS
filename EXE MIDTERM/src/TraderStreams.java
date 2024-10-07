import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TraderStreams {

    public static class Trader{
        private final String name;
        private final String city;
        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }
        public String getName(){
            return this.name;
        }
        public String getCity(){
            return this.city;
        }
        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }

    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return this.trader;
        }

        public int getYear() {
            return this.year;
        }

        public int getValue() {
            return this.value;
        }

        public String toString() {
            return "{" + this.trader + ", " +
                    "year: " + this.year + ", " +
                    "value:" + this.value + "}";
        }
    }



    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1 Find all transactions in the year 2011 and sort them by value (small to high).

        List<Transaction> t2011 = transactions.stream()
                .filter((x) -> x.year == 2011)
                .sorted((x, y) -> Integer.compare(x.value, y.value))
                .collect(Collectors.toList());

        System.out.println(t2011);

        //2 What are all the unique cities where the traders work?

        List<String> cities = transactions.stream()
                .map(x -> x.trader.city)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(cities);

        //3 Find all traders from Cambridge and sort them by name.

        List<Trader> milan = transactions.stream()
                .filter(x -> x.trader.city == "Cambridge")
                .sorted((x, y) -> x.trader.name.compareTo(y.trader.name))
                .map(x -> x.trader)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(milan);

        //4 Return a string of all traders’ names sorted alphabetically.

        String names = transactions.stream()
                .map(x -> x.trader.name)
                .distinct()
                .sorted((x, y) -> x.compareTo(y))
                .reduce("", (x, y) -> x + " " + y);
        System.out.println(names);

        //5 Are any traders based in Milan?

        Boolean milanBased = transactions.stream()
                .map(x -> x.trader)
                .anyMatch(x -> x.city == "Milan");

        System.out.println(milanBased);

        //6 Print all transactions’ values from the traders living in Cambridge.

        transactions.stream()
                .filter(x -> x.trader.city == "Cambridge")
                .map(x -> x.value)
                .forEach(System.out::println);

        //7 What’s the highest value of all the transactions?

        Optional<Integer> max = transactions.stream()
                .map(x -> x.value)
                .reduce((x, y) -> Integer.max(x, y));

        System.out.println(max.isPresent() ? max.get() : "");


        //8 Find the transaction with the smallest value.

        Optional<Integer> min = transactions.stream()
                .map(x -> x.value)
                .reduce(Integer::min);
        System.out.println(min.isPresent() ? min.get() : "");


        String s = "abca";
        int maxLen = 0;

        int s1 = Arrays.stream(s.substring(0,1))
                .distinct().collect(Collectors.toList()).size();
        System.out.println(s1);


        System.out.println(maxLen);


        String str = "a";
        System.out.println(str.substring(0, 0));






        Predicate<Integer> even = (a)->a%2==0;

        Predicate<Integer> odd = even.negate();

    }

}
