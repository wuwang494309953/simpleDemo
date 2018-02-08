package 排序;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2018/2/8.
 */
public class QuickSort {

    public static final int size = 100000;

    public int[] array = new int[size];

    @Before
    public void before() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
    }

    @Test
    public void test() {
        System.out.println("排序前--- " + Arrays.toString(array));
        long startTime = System.currentTimeMillis();

        quick(array, 0, array.length -1);

        long endTime = System.currentTimeMillis();
        System.out.println("排序后--- " + Arrays.toString(array));
        System.out.println("耗时为: " + (endTime - startTime) + " ms");
    }

    private void quick(int[] array, int ln, int rn) {
        if (ln > rn) {
            return;
        }
        int part = partition(array, ln , rn);
        quick(array, ln, part - 1);
        quick(array, part + 1, rn);
    }

    private int partition(int[] array, int ln, int rn) {
        int key = array[ln];
        int left = ln;
        while (ln < rn) {
            while (array[rn] >= key && rn > ln) {
                rn --;
            }
            while (array[ln] <= key && rn > ln) {
                ln ++;
            }
            int temp = array[rn];
            array[rn] = array[ln];
            array[ln] = temp;
        }

        array[left] = array[ln];
        array[ln] = key;

        return ln;
    }
}
