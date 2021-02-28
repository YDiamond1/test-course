import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import java.math.BigDecimal
object Fun {


    val begin =  PI/2;
    val precision = 0.00001;
    var counter = 0

    fun acos(x: Double):Double{

        if(abs(x)>1) return Double.NaN
        if(x == 1.0) return 0.0
        if(x == -1.0) return PI
        val true_precision = precision.pow(2)
        var coef = 1.0
        var prev : Double
        var current = x
        var result = x
        var sequenceCoef = 1.0
        do{
            prev = current
            coef = coef * sequenceCoef/(sequenceCoef+1)
            sequenceCoef+=2
            current = coef * x.pow(sequenceCoef)/sequenceCoef
            result += current
            counter+=1
        }while (abs(current - prev) >= true_precision)
        return begin - result;
    }


}
