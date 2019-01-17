package Stacks_Queues;

public class TowersOfHanoiWithnDisksAnd3Towers_4 {

	// Assuming n-th disk is bottom disk (count down)
	public static void tower(int n,char source,char destination,char auxillary){
		// Base case (termination condition)
		if (n == 0) return;

		// Move first n-1 disks from source pole to auxiliary pole using destination as temporary pole
		tower(n-1,source,auxillary,destination);
		System.out.println("Move disk "+n+" from "+source+" to "+destination);

		/* Move the n-1 disks from auxiliary (now source) pole to destination pole 
			using source pole as temporary (auxiliary) pole*/
		tower(n-1,auxillary,destination,source);
	}

	public static void main(String []args){
		System.out.println("Follow below steps:-\n");
		tower(3,'S','D','A');
	}
}
