package app;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }

    @FunctionalInterface
    interface StringManipulator {
        String manipulate(String input);
    }

    static class StringListProcessor {
        public static int countUppercase(String s) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    count++;
                }
            }
            return count;
        }
    }

    static class RandomNumberGenerator {
        public static int generateRandomNumber(int min, int max) {
            return (int) (Math.random() * (max - min + 1)) + min;
        }
    }

    public static void main(String[] args) {

        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        System.out.println("Результат додавання: " + addition.operate(5, 10));

        StringManipulator toUpperCase = (input) -> input.toUpperCase();
        System.out.println("Перетворення в верхній регістр: " + toUpperCase.manipulate("BiG JaVa BoSS"));

        Function<String, Integer> countUppercaseFunction = StringListProcessor::countUppercase;
        System.out.println("Кількість великих літер: " + countUppercaseFunction.apply("BiG JaVa BoSS"));

        Supplier<Integer> randomSupplier = () -> RandomNumberGenerator.generateRandomNumber(1, 100);
        System.out.println("Випадкове число: " + randomSupplier.get());
    }
}
