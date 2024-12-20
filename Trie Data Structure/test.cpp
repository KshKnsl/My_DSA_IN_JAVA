#include <iostream>
#include <vector>
using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
vector<TreeNode *> generateTrees(int start, int end)
{
    vector<TreeNode *> trees;
    if (start > end)
    {
        trees.push_back(NULL);
        return trees;
    }
    for (int i = start; i <= end; ++i)
    {
        vector<TreeNode *> leftTrees = generateTrees(start, i - 1);
        vector<TreeNode *> rightTrees = generateTrees(i + 1, end);
        for (TreeNode *left : leftTrees)
        {
            for (TreeNode *right : rightTrees)
            {
                TreeNode *root = new TreeNode(i);
                root->left = left;
                root->right = right;
                trees.push_back(root);
            }
        }
    }
    return trees;
}
vector<TreeNode *> generateTrees(int n)
{
    if (n == 0)
        return {};
    return generateTrees(1, n);
}
void preorderTraversal(TreeNode *root)
{
    if (!root)
        return;
    cout << root->val << " ";
    preorderTraversal(root->left);
    preorderTraversal(root->right);
}
int main()
{
    int n = 3;
    vector<TreeNode *> trees = generateTrees(n);
    cout << "Number of unique BSTs: " << trees.size() << endl;
    for (TreeNode *tree : trees)
    {
        preorderTraversal(tree);
        cout << endl;
    }
    return 0;
}