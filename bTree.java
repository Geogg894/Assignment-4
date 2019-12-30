import acm.program.*;


/**
 * Implements a B-Tree class using a NON-RECURSIVE algorithm.
 * Sorts aBall objects
 * @author ferrie-modified by George G
 *
 */

//javadoc documentation sourced from bTree from myCourses.



public class bTree {

	private double X=0;
	//X coordinate
	private double Y=0;
	//Y coordinate
	private double bSizelast=0;
	//radius of previous ball
	private final double DELTASIZE =0.1;
	//value which must remain less than bSize-bSizelast
	private bNode root=null;
	//set to null
	private boolean running; 
	//boolean flag
	boolean trace1=false;           //setting up boolean variable for trace.

	
	
	// Instance variables



	/**
	 * bNode class defines left and right successors as well as 
	 * accomodates the aBall objects.
	 */

	public class bNode{


		double bSize;

		aBall iBall;
		bNode right;
		bNode left;


	}

	/**
	 * makeNode
	 * 
	 * Creates a single instance of a bNode
	 * 
	 * @param	int data   Data to be added
	 * @return  bNode node Node created
	 */



	/**
	 * inorder method - inorder traversal via call to recursive method
	 */

	//javadoc documentation sourced from bTree from myCourses.

	bNode makeNode(aBall iBall) {



		//root.bSize = iBall.getbSize(); //getting the size of the ball


		bNode node= new bNode(); //new object
		node.bSize=iBall.getbSize();
		node.iBall=iBall;
		node.left=null; //set to null
		node.right=null;//set to null
		return node;



	}


	

	

	public void addNode(aBall iBall)   {   //accomodating aBall objects




		bNode current;

		//Empty tree



		if (root == null) {
			root = makeNode(iBall);
		}

		// If not empty, descend to the leaf node according to
		// the input data.  

		else {
			current = root;



			while (true) {

				if (iBall.getbSize() < current.iBall.getbSize()){

					// New data < data at node, branch left

					if (current.left == null) {				// leaf node
						current.left = makeNode(iBall);		// attach new node here
						break;
					}
					else {									// otherwise
						current = current.left;				// keep traversing
					}
				}
				else {
					// New data >= data at node, branch right

					if (current.right == null) {			// leaf node	
						current.right = makeNode(iBall);		// attach
						break;
					}
					else {									// otherwise 
						current = current.right;			// keep traversing
					}
				}

			}

		}

	}

	//sourced from bTree on myCourses.


	/**
	 * traverse_inorder methods - recursively traverses tree in order (LEFT-Root-RIGHT) and prints each node
	 * second and third traverse inorder methods sets each ball at each position as true or false.
	 */
	
	
	

	public void traverse_inorder(bNode root) {
		if (root.left != null) traverse_inorder(root.left);
		if (root.iBall.isRunning()==true) running=true;
		if (root.right != null) traverse_inorder(root.right); 
		
		
	}

	
	public void setTraceOff(bNode root) {
		if (root.left != null) traverse_inorder(root.left);
		
		root.iBall.setVisibleasFalse();
		
		if (root.right != null) traverse_inorder(root.right); 
		
		//sets boolean value as false at each position.
	}
	
	public void setTraceOn(bNode root) {
		if (root.left != null) traverse_inorder(root.left);
		
		root.iBall.setVisibleasTrue();
		
		if (root.right != null) traverse_inorder(root.right); 
		
		//sets boolean value as true at each position
	}
	



	/**
	 * isRunning() method, determines if balls are still running
	 * @return running if the simulation is still taking place
	 */
	public boolean isRunning() {
		this.running = false;		
		traverse_inorder(root);		
		return running;

	}

	/**
	 * Recursive traversal used to update the "running" status of the balls
	 * @param root-used to update the flag
	 */


	
	/**
	 * two methods which will be used to set root as false and true respectively.
	 */

	public void traceOff()
	{
		setTraceOff(root);
	}
	
	
	public void traceOn() {
		
		setTraceOn(root);
	}
	
	
	
	
	
	/**
	 * stackBalls() is responsible for the stacking of the balls.
	 */

	public void stackBalls() {

		SortBallsinOrder(root);
		 X=0;
	     Y=0;
	     bSizelast=0;
	     

	}
	
	
    /**
     * This method allows for the stopping of the bTree.
     * @param root
     */
	
	
	
	
     /**
	 * this method will allow for the use of root within bSIm
	 */
	
	public void Stop() {
		traverse_inorderStopTree(root);
	}

	public void traverse_inorderStopTree(bNode root){
		
		if(root.left!=null)traverse_inorderStopTree(root.left);
		root.iBall.running=false;
		if(root.right!=null)traverse_inorderStopTree(root.right);
		
	}
	
	/**
	 * This method allows for the sorting of the balls order of size.
	 * @param root
	 */

	public void SortBallsinOrder(bNode root) {

		if (root.left!=null)//traversing
			SortBallsinOrder(root.left);

		if(root.bSize-bSizelast>DELTASIZE) {           //based on Algorithm from Assignment 3.

			X+=2*bSizelast; //shift
			Y=root.iBall.getbSize();//places ball on ground.
			root.iBall.moveTo(X,Y); //moves ball to location
			bSizelast = root.bSize;
		}

		else {

			Y+=2*root.iBall.getbSize();                  //places ball on top of the other.
			root.iBall.moveTo(X,Y);
			bSizelast = root.bSize;
		}

		if(root.right!=null) {

			SortBallsinOrder (root.right); //traversing

		}
    
		

	}

}






































