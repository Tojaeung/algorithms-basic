import java.util.Scanner;

public class 복습연습장 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 0;
        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;

            cnt += (n - target);
            n = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n == 1) {
                break;
            }

            // K로 나누기
            cnt += 1;
            n /= k;
        }

        System.out.println(n);
        cnt += (n - 1);
        System.out.println(cnt);

    }
}
