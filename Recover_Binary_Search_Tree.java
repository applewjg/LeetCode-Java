
public class Recover_Binary_Search_Tree {
	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		Result res = recursion(root);

		TreeNode mistake_root = res.node;
		TreeNode mis1 = mistake_root;
		TreeNode mis2 = null;
		mis1 = findRightMis(mistake_root.right);
		mis2 = findLeftMis(mistake_root.left);
		if (mis1 == null) {
			mis1 = mistake_root;
		} else if (mis2 == null) {
			mis2 = mistake_root;
		} else {
			if (mis1.val < mistake_root.val && mis2.val < mistake_root.val) {
				mis2 = mistake_root;
			}
			if (mis1.val > mistake_root.val && mis2.val > mistake_root.val) {
				mis1 = mistake_root;
			}
		}
		int tmp = mis1.val;
		mis1.val = mis2.val;
		mis2.val = tmp;
		return;
	}

	// find the highest level of TreeNode where the mistake happens
	public Result recursion(TreeNode root) {
		if (root.left == null && root.right == null)
			return new Result(null, root.val, root.val);
		Result left = null;
		Result right = null;
		if (root.left == null && root.right != null) {
			right = recursion(root.right);
			if (right.min > root.val) {
				return new Result(right.node, right.max, root.val);
			} else {
				if (root.val > right.max) {
					return new Result(root, root.val, right.min);
				} else {
					return new Result(root, right.max, right.min);
				}
			}
		} else if (root.left != null && root.right == null) {
			left = recursion(root.left);
			if (left.max < root.val) {
				return new Result(left.node, root.val, left.min);
			} else {
				if (root.val < left.min) {
					return new Result(root, left.max, root.val);
				} else {
					return new Result(root, left.max, left.min);
				}
			}
		} else {
			left = recursion(root.left);
			right = recursion(root.right);
			TreeNode left_tmp = null;
			TreeNode right_tmp = null;
			TreeNode mis = null;
			if (left.max > root.val || right.min < root.val) {
				mis = root;
			} else {
				if (left.node != null) {
					mis = left.node;
				} else {
					mis = right.node;
				}
			}
			int max_tmp = maxTN(root.val, left.max, right.max);
			int min_tmp = minTN(root.val, left.min, right.min);
			return new Result(mis, max_tmp, min_tmp);
		}
	}

	public int maxTN(int t1, int t2, int t3) {
		if (t1 > t2 && t1 > t3)
			return t1;
		else if (t2 > t1 && t2 > t3)
			return t2;
		else
			return t3;
	}

	public int minTN(int t1, int t2, int t3) {
		if (t1 < t2 && t1 < t3)
			return t1;
		else if (t2 < t1 && t2 < t3)
			return t2;
		else
			return t3;
	}

	public TreeNode findRightMis(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		else if (root.left == null && root.right != null) {
			// return min
			TreeNode right = findRightMis(root.right);
			if (right.val < root.val)
				return right;
			return root;
		} else if (root.left != null && root.right == null) {
			TreeNode left = findRightMis(root.left);
			if (left.val < root.val)
				return left;
			return root;
		} else {
			TreeNode right = findRightMis(root.right);
			TreeNode left = findRightMis(root.left);
			if (right.val < root.val && right.val < left.val)
				return right;
			else if (left.val < root.val && left.val < right.val)
				return left;
			return root;
		}
	}

	public TreeNode findLeftMis(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		else if (root.left == null && root.right != null) {
			// return min
			TreeNode right = findLeftMis(root.right);
			if (right.val > root.val)
				return right;
			return root;
		} else if (root.left != null && root.right == null) {
			TreeNode left = findLeftMis(root.left);
			if (left.val > root.val)
				return left;
			return root;
		} else {
			TreeNode right = findLeftMis(root.right);
			TreeNode left = findLeftMis(root.left);
			if (right.val > root.val && right.val > left.val)
				return right;
			else if (left.val > root.val && left.val > right.val)
				return left;
			return root;
		}
	}
}
class Result{
    TreeNode node;
    int max;
    int min;
    Result(TreeNode node, int max, int min){
        this.max = max;
        this.min = min;
        this.node = node;
    }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
