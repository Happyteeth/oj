package 序列化二叉树;


import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        LinkedList<LinkedList<TreeNode>> list = new LinkedList();
        LinkedList<TreeNode> list2 = new LinkedList();
        list2.offer(root);
        list.offer(list2);
        sb = sb.append(root.val+",");
        int size = 0;
        while(list.size()>0){
            LinkedList<TreeNode> tmp = list.poll();
            LinkedList list3 = new LinkedList();
            while(tmp.size()>0){
                TreeNode tn = tmp.poll();
        
                if(tn.left!=null){
                    list3.offer(tn.left);
                    sb = sb.append(tn.left.val+",");
                }else{
                    sb = sb.append("null,");
                }
                if(tn.right!=null){
                    list3.offer(tn.right);
                    sb = sb.append(tn.right.val+",");
                }else{
                    sb = sb.append("null,");
                }
            }
            if(list3.size()>0){
                list.offer(list3);
                size = list3.size();
            }
        }
        String re[] = sb.toString().substring(0,sb.length()-1).split(",");
        sb = new StringBuffer();
        for(int i=0;i<re.length-size*2;i++){
            sb = sb.append(re[i]+",");
        }
        // todo 1,2,3,null,null,4,5
        return sb.toString().substring(0, sb.length()-1);
    }

    // TODO 优化版本Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        LinkedList<LinkedList<TreeNode>> list = new LinkedList();
        LinkedList<TreeNode> list2 = new LinkedList();
        list2.offer(root);
        list.offer(list2);

        while(list.size()>0){
            LinkedList<TreeNode> tmp = list.poll();
            LinkedList list3 = new LinkedList();
            while(tmp.size()>0){
                TreeNode tn = tmp.poll();
                if(tn!=null){
                    sb = sb.append(tn.val+",");
                    list3.offer(tn.left);
                    list3.offer(tn.right);
                }else{
                    sb = sb.append("null,");
                }

            }
            if(list3.size()>0){
                list.offer(list3);
            }

        }
        // todo deletecharAt  1,2,3,null,null,4,5,null,null,null,null 情况
        return sb.deleteCharAt(sb.length()-1).toString();
    }


    // TODO 优化版本Encodes a tree to a single string.
    public String serialize3(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuffer sb = new StringBuffer();

        LinkedList<TreeNode> list2 = new LinkedList();
        list2.offer(root);

        while(list2.size()>0){
                TreeNode tn = list2.poll();
                if(tn!=null){
                    // 关注打印
                    sb = sb.append(tn.val+",");
                }else{
                    sb = sb.append("null,");
                }
                list2.offer(tn.left);
                list2.offer(tn.right);
        }
        // todo deletecharAt
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if(data==null||"".equals(data)){
            return null;
        }
     
        LinkedList<TreeNode> l = new LinkedList<>();
 
        int i=0,j=1;
        String nodeVal[] = data.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(nodeVal[0]));
        l.offer(head);
        while(l.size()>0&&i<nodeVal.length){
            TreeNode t = l.poll();
            i++;
            
            if(i<nodeVal.length&&!"null".equals(nodeVal[i])){
                TreeNode tN = new TreeNode(Integer.parseInt(nodeVal[i]));
                l.offer(tN);
                System.out.println(l.peek().val);
                t.left = tN;
            }
            i++;
            if(i<nodeVal.length&&!"null".equals(nodeVal[i])){
                TreeNode tN = new TreeNode(Integer.parseInt(nodeVal[i]));
                l.offer(tN);
                System.out.println(l.peek().val);
                t.right = tN;
            }

        }
        
        return head;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));