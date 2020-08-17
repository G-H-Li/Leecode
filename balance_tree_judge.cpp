/**
 * 2020-8-17
 * 平衡二叉树判断
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 关键点：平衡二叉树的遍历
 * 定义：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */

#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int findDepth(TreeNode* root, int depth){
    depth += 1;
    int lDepth = depth, rDepth = depth;
    if(root->left == NULL && root->right == NULL)
    {
        return depth;
    }
    if(root->left != NULL){
        lDepth = findDepth(root->left, depth);
    }
    if(root->right != NULL){
        rDepth = findDepth(root->right, depth);
    }
    if(abs(lDepth - rDepth) > 1){
        return -2;
    }
    return lDepth>=rDepth? lDepth:rDepth;
}

bool isBalanced(TreeNode* root) {
    if(root == NULL){
        return true;
    }
    if(findDepth(root, 0) == -2){
        return false;
    }else{
        return true;
    }
}