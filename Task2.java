import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N: ");
        int n = sc.nextInt();

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++)
            nums.add(sc.nextInt());

        // Сортировка
        Collections.sort(nums);
        System.out.println("Вывод1: " + nums);

        // Без повторений
        Set<Integer> unique = new LinkedHashSet<>(nums);
        System.out.println("Вывод2: " + new ArrayList<>(unique));

        sc.close();
    }
}