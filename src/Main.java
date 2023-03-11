import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int M = scanner.nextInt();

        int[][] tab = new int[N][2];

        for (int i = 0; i < N; i++) {
            tab[i][0] = scanner.nextInt();
            tab[i][1] = scanner.nextInt();
        }
        scanner.close();
        

        int sumHeight = 0;
        int sumWidth = 0;

        double[] ratio = new double[N];
        double maxRatio = 0.0;

        for (int i = 0; i < N; i++) {
            ratio[i] = (double) tab[i][0] / tab[i][1];
            ratio[i] = Math.round(ratio[i] * 10) / 10.0;
            if (ratio[i] > maxRatio) maxRatio = ratio[i];
        }

        while (maxRatio > 0) {
            for (int i = 0; i < N && maxRatio > 0; i++) {

                if (ratio[i] == maxRatio) {
                    sumWidth += tab[i][1];
                    if (sumWidth > M) {
                        System.out.println(sumHeight);
                        System.exit(0);
                    }
                    sumHeight += tab[i][0];
                }

                if (i == N - 1) {
                    i = -1;
                    maxRatio = maxRatio - 0.1;
                    maxRatio = Math.round(maxRatio * 10) / 10.0;
                }
            }

        }

    }
}