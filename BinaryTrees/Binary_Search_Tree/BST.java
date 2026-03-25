public class BST<T extends Comparable<T>>{
	public Node<T> root;

	public void insert(T data){
		this.root = this.insert(data, this.root);
	}

	private Node<T> insert(T data, Node<T> node){
		if (node == null){
			return new Node<T>(data);
		}

		if (data.compareTo(node.data) < 0){
			node.left = this.insert(data, node.left);
		}
		else if (data.compareTo(node.data) > 0){
			node.right = this.insert(data, node.right);
		}

		return node;
	}

	public void delete(T data){
		this.root = this.delete(data, this.root);
	}

	public Node<T> delete(T data, Node<T> node){
		if (node == null){
			return null;
		}

		if (data.compareTo(node.data) < 0){
			node.left = this.delete(data, node.left);
		}
		else if (data.compareTo(node.data) > 0){
			node.right = this.delete(data, node.right);
		}
		else {
			if (node.left == null){
				return node.right;
			}
			else if (node.right == null){
				return node.left;
			}
			else{
				T successor = this.findMin(node.right);
				node.data = successor; 

				node.right = this.delete(successor, node.right);
			}
		}

		return node;
	}

	public void search(T data){
		this.search (data, root);
	}

	private void search(T data, Node<T> node){
		if (node == null){
			System.out.println("Item not found!!");
		}

		if (data.compareTo(node.data) < 0){
			this.search(data, node.left);
		}
		else if (data.compareTo(node.data) > 0){
			this.search(data, node.right);
		}
		else{
			System.out.println("Found");
		}
	} 

	public int height(){
		return this.height(this.root);
	}

	private int height(Node<T> node){
		if (node == null){
			return -1;
		}

		return 1 + Math.max(this.height(node.left), this.height(node.right));
	}

	public int size(){
		return this.size(this.root);
	}

	private int size(Node<T> node){
		if (node == null){
			return 0;
		}
		return 1 + this.size(node.left) + this.size(node.right);
	}

	public T findMin(Node<T> node){

		while (node.left != null){
			node = node.left;
		}

		return node.data;
	}

	public T findMax(Node<T> node){
		while (node.right != null){
			node = node.right;
		}

		return node.data;
	}

	public void preOrder(){
		this.preOrder(this.root);
	}

	private void preOrder(Node<T> node){
		if (node != null){
			this.visit(node);
			this.preOrder(node.left);
			this.preOrder(node.right);
		}
	}

	public void inOrder(){
		this.inOrder(this.root);
	}

	private void inOrder(Node<T> node){
		if (node != null){
			this.inOrder(node.left);
			this.visit(node);
			this.inOrder(node.right);
		}
	}

	public void postOrder(){
		this.postOrder(this.root);
	}

	private void postOrder(Node<T> node){
		if (node != null){
			this.postOrder(node.left);
			this.postOrder(node.right);
			this.visit(node);
		}
	}

	public void levelOrder(){
		java.util.Queue<Node<T>> treeQueue = new java.util.ArrayDeque<Node<T>>();
		treeQueue.add(this.root);

		Node<T> temp;

		while (treeQueue.peek() != null){
			temp = treeQueue.remove();

			this.visit(temp);

			if (temp.left != null){
				treeQueue.add(temp.left);
			}
			if (temp.right != null){
				treeQueue.add(temp.right);
			}
		}
	}

	private void visit(Node<T> node){
		System.out.println(node.data);
	}
}
