public class avlTree<T extends Comparable<T>>{
	public Node<T> root;

	public int size(){
		return this.size(this.root);
	}

	private int size(Node<T> node){
		if (node == null){
			return 0;
		}

		return 1 + this.size(node.left) + this.size(node.right);
	}

	public int treeHeight(){
		return this.getHeight(node); 
	}

	private int getHeight(Node<T> node){
		if (node == null){
			return -1;
		}

		return Math.max(this.getHeight(node.left), this.getHeight(mode.right)) + 1;
	}

	private int height(Node<T> node){
		if (node != null){
			return node.height;
		}

		return -1;
	}

	private void updateHeight(Node<T> node){
		node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
	}

	private int balanceFactor(Node<T> node){
		return this.height(node.right) - this.height(node.left);
	}

	private Node<T> balance(Node<T> node){
		
		this.updateHieght(node);

		if (this.balanceFactor(node) == 2){
			if (this.balanceFactor(node.right) <= 0){
				node.right = this.rotateRight(node.right);
			}

			return this.rotateLeft(node);
		}

		if (this.balanceFactor(node) == -2){
			if (this.balanceFactor(node.left) > 0){
				node.left = this.rotateLeft(node.left);
			}

			return this.rotateRight(node);

		}

		return node;
	}

	private Node<T> rotateLeft(Node<T> node){
		Node<T> rightChild = node.right;
		node.right = rightChild.left;
		rightChild.left = node;

		this.updateHeight(node);
		this.updateHeight(rightChild);
	}

	private Node<T> rotateRight(Node<T> node){
		Node<T> leftChild = node.left;
		node.left = leftChild.right;
		leftChild.right = node;

		this.updateHeight(node);
		this.updateHeight(leftChild);

		return leftChild;
	}

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

		return this.balance(node);
	}

