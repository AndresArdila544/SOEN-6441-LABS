import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListsUsage {
    //1
    interface SumCalc {
        int sum(int a,int b);
    }
    //2
    interface StringCheck{
        boolean isEmpty(String s);
    }
    //3
    interface ChangeCase{
        String changeCase(String s);
    }
    //4
    interface FilterNumber{
        void filter(List ls,Predicate ts);
    }

    interface AverageList{

        double average(List<Double> ls);
    }
    interface StringAdder{

        String add(String a,String b);
    }


    public static void main(String[] args) {
        //1 Write a Java program to implement a lambda expression to find the sum of two integers.
        int a=2,b=4;
        SumCalc sc=(x,y)->x+y;
        System.out.println(sc.sum(a,b));

        //2 Write a Java program to implement a lambda expression to check if a given string is empty.
        String s = "Hello";
        StringCheck stc = (x)->x.isEmpty();
        System.out.println(stc.isEmpty(s));
        System.out.println(stc.isEmpty(""));

        //3 Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.
        String[] as= new String[]{"Hola","no","tengo","ganas"};
        List<String> lsa = new ArrayList<>(Arrays.asList(as));
        ChangeCase up = (x)->x.toUpperCase();
        ChangeCase down = String::toLowerCase;

        for(Object i:lsa){
            System.out.println(up.changeCase(i.toString()));
            System.out.println(down.changeCase(i.toString()));
        }

        //4 Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
        Integer[] l1 = new Integer[]{1,3, 5, 6, 7, 8, 9, 10};
        List<Integer> ls = new ArrayList<>(Arrays.asList(l1));
        Predicate<Integer> odd= (x)->x%2!=0;
        FilterNumber filter = (x,y)->x.removeIf(y);

        filter.filter(ls,odd);
        for(Object i:ls){
            System.out.println(i.toString());
        }

        //5 Write a Java program to implement a lambda expression to sort a list of strings in alphabetical order.
        as= new String[]{"Hola","no","tengo","ganas"};
        lsa = new ArrayList<>(Arrays.asList(as));

        lsa.sort((x,y)->String.valueOf(x.toUpperCase().charAt(0)).compareTo(String.valueOf(y.toUpperCase().charAt(0))));
        for(Object i:lsa){
            System.out.println(i.toString());
        }
        lsa.sort(Comparator.comparing(x -> String.valueOf(x.toUpperCase().charAt(0))));
        for(Object i:lsa){
            System.out.println(i.toString());
        }

        //6 Write a Java program to implement a lambda expression to find the average of a list of doubles.
        Double[] da = new Double[]{1.0,2.3,4.5,7.5,8.7};
        List<Double> lda = new ArrayList<>(Arrays.asList(da));

        AverageList avg = (x)->{
            double sum=0;
            for(Double d:x){
                sum+=d;
            }
            return sum/x.size();
        };

        System.out.println(avg.average(lda));

        //7 Write a Java program to implement a lambda expression to remove duplicates from a list of integers.
        l1 = new Integer[]{1,3, 5, 6, 7, 8, 9, 10,10,10,6,5,7,3,1,};
        ls = new ArrayList<>(Arrays.asList(l1));

        List<Integer> nl = new ArrayList<>();
        ls.stream().distinct().forEach((x)->nl.add(x));

        for(Object i:nl){
            System.out.println(i.toString());
        }

        //8 Write a lambda expression to implement a lambda expression to calculate the factorial of a given number.
        int z=5;

        Function<Integer,Integer> factorial = n->{
            int result = 1;
            for(int i =0;i<=n;i++){
                result*=i;
            }
            return result;
        };

        System.out.println(factorial.apply(z));

        //9 Write a Java program to implement a lambda expression to create a lambda expression to check if a number is prime.

        Function<Integer,Boolean> prime=n->{
            if(n<=1) return false;
            for (int i =2 ; i <n-1; i++) {
                if(n%i==0)
                    return false;
            }
            return true;
        };

        System.out.println(prime.apply(10));
        System.out.println(prime.apply(31));

        //10 Write a Java program to implement a lambda expression to concatenate two strings.

        StringAdder adder= (x,y) -> x.concat(y);

        System.out.println(adder.add("hola","amigo"));

        //11
    }
}