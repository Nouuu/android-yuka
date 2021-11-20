package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import java.text.DecimalFormat

fun main() {
    print(factorial(5))
}

fun TVA() {
    val df = DecimalFormat("#,###.##")
    print("Saisissez votre montant HT :\n> ")
    val value = readLine()?.toInt()
    if (value != null) {
        println("TVA 2,1% : ${df.format(value * 1.021)}€")
        println("TVA 5,5% : ${df.format(value * 1.055)}€")
        println("TVA 10% : ${df.format(value * 1.1)}€")
        println("TVA 20% : ${df.format(value * 1.2)}€")
    }
}

fun Int.isEven(): Boolean {
    return if (this % 2 == 0) true else false;
}

fun isVoyelle(value: Char): Boolean {
    return when (value) {
        'a', 'e', 'i', 'o', 'u', 'y' -> true
        else -> false
    }
}

fun onToHundred() {
    for (i in 0 until 101) {
        println(i)
    }
}

fun onToHundredRange() {
    for (i in 0..100) {
        println(i)
    }
}

fun helloESGI(): Unit {
    return println("helloESGI")
}

fun mul5(value: Int): Int = value * 5

fun foo(name: String, number: Int? = null, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.uppercase() else name) + (number ?: "")

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

fun factorial(number: Int): Int = if (number == 1) 1 else number * factorial(number - 1)