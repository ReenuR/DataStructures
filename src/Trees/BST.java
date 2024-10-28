package Trees;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(){
    }
    TreeNode(int data){
        this.data = data;
    }
}
public class BST {

        private TreeNode root;

        public void DFSinOrder(){}
        public void delete(int value){}

        public boolean isPresent(int value){
            return false;
        }
        public boolean insert(int value){
            TreeNode newNode = new TreeNode(value);
            TreeNode current = root;

            if(root == null){
                root = newNode;
                return  true;
            }
            else{
                while(true){
                    if(value < current.data){
                        if(current.left == null){
                            current.left = newNode;
                            return true;
                        }
                        current = current.left;
                    }
                    if(value > current.data){
                        if(current.right == null){
                            current.right = newNode;
                            return true;
                        }
                        current = current.right;
                    }
                    if(value == current.data){
                        return false;
                    }
                }
            }

        }

        }




