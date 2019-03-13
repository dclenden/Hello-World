package BST;
/*
* @author David W. Clendenning Jr.
*/

public class NonEmptyBST<T extends Comparable> implements Tree<T> {
    T data;
    Tree<T> left;
    Tree<T> right;
	public NonEmptyBST(T element) {
		data = element;
		left = new EmptyBST();
		right = new EmptyBST();
	}
	
	public NonEmptyBST(T element, Tree<T> leftTree, Tree<T> rightTree) {
		data = element;
		left = leftTree;
		right = rightTree;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public int cardinality() {
		return (1 + left.cardinality() + right.cardinality());
	}
	
	public boolean member(T element) {
		if(data == element) {
			return true;
		}
		else {
			if(element.compareTo(data) < 0) {
				return left.member(element);
			}
			else {
				return right.member(element);
			}
		}
	}
	
	public NonEmptyBST<T> add(T element){
		if(data == element) {
			return this;
		}
		else {
			if(element.compareTo(data) < 0) {
				return new NonEmptyBST(data, left.add(element), right);
			}
			else {
				return new NonEmptyBST(data, left, right.add(element));
			}
		}
	}
}
