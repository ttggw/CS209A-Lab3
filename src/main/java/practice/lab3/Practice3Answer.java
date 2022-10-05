package practice.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**.
 * Array filter
 */
public class Practice3Answer {
    /**.
     * main
     *
     * @param args args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please input the function No:\n" +
                    "1 - Get even numbers\n" +
                    "2 - Get odd numbers\n" +
                    "3 - Get prime numbers\n" +
                    "4 - Get prime numbers that are bigger than 5\n" +
                    "0 - Quit\n" );
            int function = scanner.nextInt();
            if (function == 0) {
                break;
            }
            System.out.println("Input size of the list:");
            int size = scanner.nextInt();
            List<Integer> list = new ArrayList<>(size);
            System.out.println("Input elements of the list:");
            for (int i = 0; i < size; i++) {
                list.add(scanner.nextInt());
            }
            System.out.println("Filter results:");
            switch (function) {
                case 1:
                    getEvenNumbers(list);
                    break;
                case 2:
                    getOddNumbers(list);
                    break;
                case 3:
                    getOnlyPrimeNumbers(list);
                    break;
                case 4:
                    getPrimeNumbersAndLargerThanFive(list);
                    break;
                default:
                    System.out.println("Wrong function Number!");
                    break;
            }
        }
    }

    /**.
     * get even numbers
     *
     * @param list input list
     */
    public static void getEvenNumbers(List<Integer> list) {
        List<Integer> res = list.stream().filter(num -> num % 2 == 0).toList();
        System.out.println(res);
    }
    
    /**.
     * get odd numbers
     *
     * @param list input list
     */
    public static void getOddNumbers(List<Integer> list) {
        List<Integer> res = list.stream().filter(num -> num % 2 != 0).toList();
        System.out.println(res);
    }

    /**.
     * get prime numbers
     *
     * @param list input list
     */
    public static void getOnlyPrimeNumbers(List<Integer> list) {
        List<Integer> res = list.stream().filter(Practice3Answer::isPrime).toList();
        System.out.println(res);
    }

    /**.
     * get prime numbers and larger than 5
     *
     * @param list input list
     */
    public static void getPrimeNumbersAndLargerThanFive(List<Integer> list) {
        List<Integer> res = list.stream().filter(num -> isPrime(num) && num > 5).toList();
        System.out.println(res);
    }

    /**.
     * is prime
     *
     * @param number number
     * @return boolean
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
