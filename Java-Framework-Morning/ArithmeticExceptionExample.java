import java.util.Scanner;

public class ArithmeticExceptionExample {

    float divide(int number1, int number2) throws ArithmeticException
    {
        if(number2==0){
            throw new ArithmeticException("Divide by zero");
        }
        else{
            return (float) (number1/number2);
        }
    }
    public static void main(String[] args) throws ArithmeticException{

        ArithmeticExceptionExample obj = new ArithmeticExceptionExample();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dividend: ");
        int number1 = sc.nextInt();

        System.out.print("Enter divisor: ");
        int number2 = sc.nextInt();

        float ans = obj.divide(number1, number2);

        System.out.println("Answer (number1/number2) = " + ans);

    }

}
