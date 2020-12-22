import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Copyright 2020, Xiaomi.
 * All rights reserved.
 *
 * @Author: wangfan8@xiaomi.com
 */

public class ZigzagLevelOrder {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    if (root == null) {
      return ans;
    }

    Queue<TreeNode> stack = new LinkedList<>();
    if (root != null) {
      stack.offer(root);
    }
    boolean isOrder = true;

    while (!stack.isEmpty()) {
      Deque<Integer> levelList = new LinkedList<Integer>();
      int size = stack.size();

      for (int i = 0; i < size;i++) {
        TreeNode treeNode = stack.poll();
        if (isOrder) {
          levelList.offerLast(treeNode.val);
        } else {
          levelList.offerFirst(treeNode.val);
        }

        if (treeNode.left != null) {
          stack.offer(treeNode.left);
        }

        if (treeNode.right != null) {
          stack.offer(treeNode.right);
        }

      }

      ans.add(new LinkedList<>(levelList));
      isOrder = !isOrder;
    }
    return ans;
  }

  public static void main(String[] args) {
    ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
    TreeNode root = new TreeNode(3);
    TreeNode left = new TreeNode(9);
    TreeNode right = new TreeNode(20);
    TreeNode left1 = new TreeNode(15);
    TreeNode right1 = new TreeNode(7);

    TreeNode left2 = new TreeNode(11);
    TreeNode right2 = new TreeNode(17);
//    left.left = left2;
//    left.right = right2;
    right.left = left1;
    right.right = right1;
    root.left = left;
    root.right = right;

    zigzagLevelOrder.zigzagLevelOrder(root);
  }
}
