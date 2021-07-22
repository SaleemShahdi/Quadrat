import java.util.Scanner;
import java.text.DecimalFormat;
import scala.math.sqrt;
import scala.math.pow;
import scala.math.abs;
object QUADRAT {
    def main(args:Array[String]) {
        println("");
        println("Welcome to QUADRAT, a program that effortlessly");
        println("allows you to solve quadratic equations!");
        println("");
        println("All you have to do is enter the values for a, b and c");
        println("from an equation in the form of ax^2 + bx + c = 0");
        var decision: Boolean = false;
        do {
        println("");
        print("a = ");
        val a = input.readLine();
        if (a == 0) {
            println("That's a linear equation");
            print("Would you like to try again? ");
            decision = input.getDecision();
        } else {
            print("b = ");
            val b = input.readLine();
            print("c = ");
            val c = input.readLine();
            val b_squared = pow(b, 2);
            val four_ac = 4*a*c;
            val q = b_squared - four_ac;
            if (q < 0) {
                println("Sorry, the answer is imaginary");
                print("Would you like to try again? ");
                decision = input.getDecision();
            } else {
                val positive_root = ((-(b) + sqrt(q)) / (2*a)).toDouble;
                val negative_root = ((-(b) - sqrt(q)) / (2*a)).toDouble;
                val equation = getEquation(a, b, c);
                val f = new DecimalFormat("0.00");
                if (positive_root == negative_root) {
                    val result = f.format(positive_root);
                    print("The zero of " + equation + " is ");
                    println(result);
                    print("Would you like to solve another equation? ");
                    decision = input.getDecision();
                } else {
                    val result1 = f.format(negative_root);
                    val result2 = f.format(positive_root);
                    print("The zeros of " + equation + " are ");
                    print(result1);
                    print(" and ");
                    println(result2);
                    print("Would you like to solve another equation? ");
                    decision = input.getDecision();
                }
            }
        }
    } while (decision == true);
        
    }

    def getEquation(a: Double, b: Double, c: Double) :String = {
        return get_ax_squared(a) + get_bx(b) + get_c(c);
    }
    def get_ax_squared(a: Double) :String = {
        if (a == 0) {
            return "";
        } else if (a == -1) {
            return "-x^2";
        } else if (a == 1) {
            return "x^2";
        } else {
            val temp = a.toString;
            val result = temp + "x^2";
            return result;
        }

    }
    def get_bx(b: Double) :String = {
        if (b == 0){
            return "";
        } else if (b == -1) {
            return " - x";
        } else if (b == 1) {
            return " + x"
        } else if (b < 0) {
            val absb = abs(b);
            val temp = absb.toString;
            val result = " - " + temp + "x";
            return result;
        } else {
            val temp = b.toString;
            val result = " + " + temp + "x";
            return result;
        }

    }
    def get_c(c: Double) :String = {
        if (c == 0) {
            return "";
        } else if (c < 0) {
            val absc = abs(c);
            val temp = absc.toString;
            val result = " - " + temp;
            return result;
        } else {
            val temp = c.toString;
            val result = " + " + temp;
            return result;
        }

    }
}

object input {
    var keyboard = new Scanner(System.in);

    def readLine() :Double = {
        return getDouble().asInstanceOf[Double];
    }

    def getDouble() :Any = {
        while (true) {
            try {
                val s = keyboard.nextLine();
                val d = s.toDouble;
                return d;
            } catch {
                case e: NumberFormatException => print("That is not a number. Enter again: ");
            }
        }
    }

    def getDecision() :Boolean = {
        return getBoolean().asInstanceOf[Boolean];
    }

    def getBoolean() :Any = {
        while (true) {
            val s = keyboard.nextLine();
            if ((s.matches("[Yy][es]*") || (s == "YES"))) {
                return true;
            } else if ((s.matches("[Nn][o]*") || (s == "NO"))) {
                return false;
            } else {
                print("""Enter "yes" or "no": """);
            }
        }
    }
}