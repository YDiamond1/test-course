import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static double func_arccos(double x){
        return Math.acos(x);
    }
    public static void main(String[] args) {
        Double[] mas = {-0.7D, -0.6, -0.5, -0.4,-0.3,-0.2,-0.1, 0D ,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1D};
        List<Double> x = Arrays.asList(mas);
        x.forEach((val) -> System.out.println(val+","+func_arccos(val))
        );

    }
}
