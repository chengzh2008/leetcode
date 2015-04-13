package src.main.java;

/**
 * Given an array of numbers, recursively remove adjacent duplicate numbers.
 * The output array should not have any adjacent duplicates.
 *
 * for example:
 *  input: 1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5
 *  output: 1
 *
 *  input: 1, 9, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5
 *  output: 1, 9, 5.
 *
 *  Strategy: in-place stack in the array
 *
 *  use a index for the top of the in-place stack. starts from -1;
 *  from left to right, scan the item in the array:
 *  compare the current number with the top item in the in-place stack, if different,
 *  push the current number to to the in-place stack,
 *  if same, scan the next one until there is a different item, pop from the in-place stack.
 *
 *  return the stack index to show the items left in the array
 *
 */
public class RemoveAdjacentDuplicates {
    public void removeAdjacentDuplicates(int[] array) {
        int stack_index = -1;
        int i = 0;
        while (i < array.length) {
            if (stack_index == -1 || array[stack_index] != array[i]) {
                stack_index++;
                array[stack_index] = array[i];
                i++;
            } else {
                while (i < array.length && array[i] == array[stack_index]) {
                    i++;
                }
                stack_index--;
            }
        }
        for (i = 0; i<= stack_index; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveAdjacentDuplicates rds = new RemoveAdjacentDuplicates();
        int[] array1 = {1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5};
        rds.removeAdjacentDuplicates(array1);
        int[] array2 = {1, 9, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5};
        rds.removeAdjacentDuplicates(array2);

    }

}
