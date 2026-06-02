public class BPlusRangeQuery {

    public static void main(String[] args) {

        int books[] = {100, 120, 140, 160, 180, 200, 220};

        int low = 120;
        int high = 180;

        System.out.println("Books in Range:");

        for (int book : books) {
            if (book >= low && book <= high) {
                System.out.println(book);
            }
        }
    }
}