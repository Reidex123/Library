public class bstTest{
	public static void main(String[] args){
		BST<Integer> tree = new BST<Integer>();

		tree.insert(50);
		tree.insert(30);
		tree.insert(80);
		tree.insert(2);
		tree.insert(10);
		tree.insert(70);

		System.out.println("Pre-Order traversal:");
		tree.preOrder();
		System.out.println("--------------------------------------");

		System.out.println("In-Order traversal:");
		tree.inOrder();
		System.out.println("---------------------------------------");

		System.out.println("Post-Order traversal:");
		tree.postOrder();
		System.out.println("---------------------------------------");

		System.out.print("Minimum: ");
		tree.search(2);
		System.out.println();

		System.out.print("Maximum: ");
		tree.search(80);
		System.out.println();

		System.out.print("Height: ");
		System.out.println(tree.height());

		System.out.print("Size: ");
		System.out.println(tree.size());

		tree.delete(2);
		tree.delete(70);
		tree.delete(50);

		System.out.println("After deleting: 2, 70, 50");
		System.out.println("----------------------------------------");

		System.out.println("Pre-Order traversal:");
		tree.preOrder();
		System.out.println("-----------------------------------------");

		System.out.println("In-Order traversal:");
		tree.inOrder();
		System.out.println("------------------------------------------");

		System.out.println("Post-Order traversal:");
		tree.postOrder();
		System.out.println("-----------------------------------------");

		System.out.print("Minimum: ");
		tree.search(10);
		System.out.println();

		System.out.print("Maximum: ");
		tree.search(80);
		System.out.println();

		System.out.print("Height: ");
		System.out.println(tree.height());

		System.out.print("Size: ");
		System.out.println(tree.size());
	}
}
