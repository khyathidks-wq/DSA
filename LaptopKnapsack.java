public class LaptopKnapsack {

    public static void main(String[] args) {

        int[] cost = {20, 30, 40, 50};
        int[] productivity = {25, 40, 50, 60};

        String[] laptops = {
            "Dell Inspiron",
            "HP Pavilion",
            "Lenovo ThinkPad",
            "ASUS Vivobook"
        };

        int budget = 80;
        int n = cost.length;

        int[][] dp = new int[n + 1][budget + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= budget; w++) {

                if (cost[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            productivity[i - 1] +
                            dp[i - 1][w - cost[i - 1]],
                            dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Productivity Score: "
                + dp[n][budget]);

        System.out.println("\nSelected Laptops:");

        int w = budget;

        for (int i = n; i > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println(laptops[i - 1]);
                w = w - cost[i - 1];
            }
        }
    }
}