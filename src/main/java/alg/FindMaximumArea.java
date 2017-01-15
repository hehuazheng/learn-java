package alg;

import java.util.Stack;

public class FindMaximumArea {
    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3, 4, 6, 6, 2, 1, 0};
        int size = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int maxSize = height[0];
        int i = 0;
        while (i < size) {
            int curNum = height[i];
            if (stack.isEmpty() || curNum > height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();
                int width = i;
                int peek = -1;
                if (!stack.isEmpty()) {
                    peek = stack.peek();
                    width = i - stack.peek() - 1;
                }
                int currentSize = width * height[index];
                maxSize = Math.max(maxSize, width * height[index]);
                System.out.println("index: " + index + ", peek: " + peek + ",width: " + width + ",currentSize: " + currentSize + ",maxSize:" + maxSize);
            }
        }
        System.out.println(maxSize);
    }
}
