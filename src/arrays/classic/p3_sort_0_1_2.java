package arrays.classic;

public class p3_sort_0_1_2 {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        p3_sort_0_1_2_soln.find(arr);

        // System.out.println(answer);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}



class p3_sort_0_1_2_soln {

    static void find(int arr[]) {

        int low = -1; //last index at which 0 was found
        int high = arr.length; //index at which 2 begins
        int i = 0; //runner

        while (i < high) {
            int curr = arr[i];
            if (curr == 0) {
                low++;
                swap(arr, low, i);
                i++;
            } else if (curr == 1) {
                i++;
            } else if (curr == 2) {
                high--;
                swap(arr, i, high);
            }
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
