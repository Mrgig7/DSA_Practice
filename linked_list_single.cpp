class Node {
public:
	int data;
	Node* next;

	Node(int data) {
		this->data = data;
		this->next = nullptr;
	}
};

class SinglyLinkedList {
public:
	Node* head;

	SinglyLinkedList() {
		this->head = nullptr;
	}

	void add_node(int data) {
		Node* new_node = new Node(data);
		new_node->next = this->head;
		this->head = new_node;
	}
};
