public class Main {

    public static void main(String[] args) {
        int hights[] = {2,1,5,6,2,3};
        MaxAreaSolution maxArea = new MaxAreaSolution();
        System.out.println(maxArea.largestRectangleArea2(hights));

        int maxTreeData[] = {2, 5, 6, 0, 3, 1};
        MaxTreeSolution maxTreeSolution = new MaxTreeSolution();
        TreeNode root = maxTreeSolution.maxTree(maxTreeData);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
