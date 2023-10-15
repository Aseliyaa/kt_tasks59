import java.util.Scanner
import kotlin.math.pow

sealed class DataType {
    class DoubleType(val value: Double): DataType()
    class UnitType : DataType()
}

fun main(){
    val scan = Scanner(System.`in`)
    println("Enter the number:")
    val num = scan.nextInt()
    println("Enter the degree:")
    val deg = scan.nextInt()

    println("$num^$deg = ${num.exp1(deg)}")

    num.exp2(deg) {res ->
        println("$num^$deg = $res")
    }

    "string".displayTypeInfo()
    (1).displayTypeInfo()
    true.displayTypeInfo()

    DataType.DoubleType(1.4).displayTypeInfo()
    DataType.UnitType().displayTypeInfo()

}

//ex3 && ex4
fun <T> T.displayTypeInfo(){
    when (this) {
        is String -> println("это String")
        is Int -> println("это Int")
        is DataType.DoubleType ->
            println("это DoubleType со значением ${this.value}")
        is DataType.UnitType -> println("это Unit")
        else -> println("тип у ${this.toString()} неизвестен")
    }
}
//ex2
fun Int.exp2(n: Int, op: (Int) -> Unit){
    val res = this.toDouble().pow(n).toInt()
    op(res)
}
//ex1
fun Int.exp1(n: Int): Int {
    return this.toDouble().pow(n).toInt()
}