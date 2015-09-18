import java.util.Arrays;
import java.util.Stack;

/**
 * Created by sun38 on 9/16/2015.
 */
public class MaxAreaSolution {
    public int getMaxArea(int[] hights){
        int width = 0;
        int hight = 0;
        int max = 0;
        for(int i=0; i<hights.length; i++){
            width = 1;
            hight = hights[i];
            for(int j=i+1; j<hights.length; j++){
                if(hights[j] < hight){
                    break;
                }else{
                    width++;
                }
            }

            for (int j = i-1; j >= 0 ; j--) {
                if(hights[j] <hight){
                    break;
                }else
                    width++;
            }

            if(max < hight * width){
                max = hight*width;
            }
        }

        return max;
    }

    public int largestRectangleArea2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
