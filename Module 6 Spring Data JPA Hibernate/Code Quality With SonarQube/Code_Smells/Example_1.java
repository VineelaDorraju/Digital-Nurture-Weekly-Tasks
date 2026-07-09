public class CodeSmellExample {

    public void process() {

        int total = 0;

        for (int i = 0; i < 100; i++) {

            if (i % 2 == 0) {
                total += i;
            }

        }

        System.out.println("Even Total : " + total);

        total = 0;

        for (int i = 0; i < 100; i++) {

            if (i % 2 != 0) {
                total += i;
            }

        }

        System.out.println("Odd Total : " + total);

    }

}