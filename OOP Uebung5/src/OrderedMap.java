import java.util.Iterator;

class OrderedMap<T extends Shorter<T>,E>
    extends OrderedSet<T>
    implements Iterable{

    private class MapNode extends Node {
      private Set<E> myelem;

      private MapNode(T elem) {
        super(elem);
        this.myelem = new Set<E>();
      }
    }

    public Iterator<T> iterator() {
        return new MapIterator();
    }

    private class MapIterator extends SetIterator {
        public void add(E elem) {
          if(this.p == null) return;

          Node newNode = new Node(elem);

          if(this.p.prev == null) {
            newNode.next = Set.this.head;
            Set.this.head = newNode;
            newNode.next.prev=newNode;
          } else if (this.p.next == null) {
            newNode.prev = Set.this.tail;
            newNode.prev.next=newNode;
            Set.this.tail = newNode;
          } else {
            newNode.next=this.p.next;
            this.p.next.prev=newNode;
            this.p.next=newNode;
            newNode.prev=this.p;
            this.p=newNode;
          }

        }

        public Iterator<E> iterator() {
          return new SetIterator();
        }
    }


}
