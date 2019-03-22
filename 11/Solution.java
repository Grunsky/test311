import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

public class Solution {

    static int modulo(int grad, int q) {
           q = Math.abs(q);
           int res = grad % q;
           if(res < 0) res += q;
           return res;
    }
    static int closeq(int grad, int q) {
        int down = modulo(grad, q);
        int up = modulo(-grad, q);
        int res = grad;
        if(up > down) res -= down;
        else res += up;
    }

    static int func(int[] grads, int q = 5) {
        for(int i = 0; i < grads.length; i++) {
            if(grads[i] > 37) grads[i] = closeq(grads[i], q);
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] gr = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            gr[gradesItr] = gradesItem;
        }

        int[] result = func(gr);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
