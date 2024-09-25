package lesson_5;
import java.util.concurrent.*;

public class ForkJoinTaskExecutor {
    static class MyRecursiveTask extends RecursiveTask<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        MyRecursiveTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 10) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = start + (end - start) / 2;
                MyRecursiveTask leftTask = new MyRecursiveTask(array, start, mid);
                MyRecursiveTask rightTask = new MyRecursiveTask(array, mid, end);
                leftTask.fork();
                int rightResult = rightTask.compute();
                int leftResult = leftTask.join();
                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int result = forkJoinPool.invoke(new MyRecursiveTask(array, 0, array.length));
        System.out.println("Result: " + result);
    }
}