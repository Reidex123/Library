public class Node<T extends Comparable<T>>{
	public T data;
	public Node<T> left, right;
	public int height;

	public Node(T data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.height = 0;
	}
}
