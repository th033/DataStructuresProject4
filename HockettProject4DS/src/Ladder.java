/**
     * Class Name: Ladder
     * Class Author: Tyler Hockett
     * **************************
     * Purpose of the Class
     * To store binary tree of words
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     * Date Changed:
     * **************************
     * Look At This!
     * I called this class ladder because
     * I thought to myself what noun would
     * be used to access a tree. Axe came
     * to mind but that is for destroying
     * a tree and rope came to mind but
     * it's harder to use than a ladder
     * **************************
     */
public class Ladder 
{
    Tree root;
    Tree temp;
    /**
     * Constructor Name: Ladder
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * Sets the root Tree variable to null
     * to be used later
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     */
    public Ladder()
    {
        root=null;
        temp=null;
    }
     /**
     * Method Name: add
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * add words to the link list
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     *
     */
    public void add(String toAdd)
    {
        temp=new Tree();
        temp.word= toAdd.toLowerCase();
        temp.count+=1;
        if(root==null)
        {
            root=temp;
        }else if(root.word.compareTo(temp.word)==0)
        {
           root.count+=1;
        }else
        {
            recAdd(root);
        }
    }
     /**
     * Method Name: recAdd
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * recursively check the next tree
     * to see if it is greater or less 
     * than the word before
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     *
     */
    private void recAdd(Tree curTree)
    {
        if (temp.word.compareTo(curTree.word)<0)
        {
            if (curTree.left == null)
                curTree.left = temp;  
            else 
                recAdd(curTree.left);            
        }
        else if (temp.word.compareTo(curTree.word)>0)
        {
            if (curTree.right == null)
                curTree.right = temp;
            else 
                recAdd(curTree.right);
        }else
        {
            curTree.count+=1;
        }
    }
     /**
     * Method Name: printOut
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to call recPrintOut and finally
     * return the string
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     *
     */
    public String printOut()
    {
        return recPrintOut(root);
    }
     /**
     * Method Name: recPrintOut
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to check if there is a left, passes left
     * then check if theres a right after
     * adding the curTree value
     * to get all values from the binarytree
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     *
     */
    private String recPrintOut(Tree cur)
    {
        String tempString = "";
        if (cur.left != null)
            tempString = recPrintOut(cur.left);
        
        tempString  += "\n" + cur.word+"\t\t\t"+cur.count;
        
        if (cur.right != null)
            tempString += recPrintOut(cur.right);
        
        return tempString;
            
    }
    
    
}
