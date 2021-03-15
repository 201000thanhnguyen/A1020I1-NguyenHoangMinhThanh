package _13_Thuat_Toan_Tim_Kiem._thuc_hanh;

public class Call {
    public static void main(String[] args) {
        System.out.println(BinarySearch.binarySearch(BinarySearch.list, 2));  /* 0 */
        System.out.println(BinarySearch.binarySearch(BinarySearch.list, 11)); /* 4 */
        System.out.println(BinarySearch.binarySearch(BinarySearch.list, 79)); /*12 */
        System.out.println(BinarySearch.binarySearch(BinarySearch.list, 1));  /*-1 */
        System.out.println(BinarySearch.binarySearch(BinarySearch.list, 5));  /*-1 */
        System.out.println(BinarySearch.binarySearch(BinarySearch.list, 80)); /*-1 */
    }
}
