import java.util.LinkedList;


public class CardStack {

    // The LinkedList provides all the stack functionality we need.
    private LinkedList<Card> stack;

    public CardStack() {
        stack = new LinkedList<Card>();
    }


    public void push(Card card) {
        stack.push(card);
    }


    public Card pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.pop();
    }


    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public int size() {
        return stack.size();
    }
}