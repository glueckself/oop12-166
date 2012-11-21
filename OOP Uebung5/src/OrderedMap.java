import java.util.Iterator;

class OrderedMap <T extends Shorter<T>, E>
    extends OrderedSet<T>
    implements Iterable<T> {

    protected MapNode head;
    protected MapNode tail;

    private class MapNode extends Node {
      private InnerSet<E> innerSet;

      private MapNode(T elem) {
        super(elem);
        this.innerSet = new InnerSet<E>();
      }
    }

    public Iterator<T> iterator() {
        return new MapIterator();
    }

    private class InnerSet<E> extends Set<E> {

      public Iterator<E> iterator() {
        return new InnerSetIterator();
      }

      private class InnerSetIterator extends SetIterator {
          public void add(E elem) {

            if(this.p == null) return;

            InnerSet<E>.Node newNode = new Node(elem);

            if(this.p.prev == null) {
              newNode.next = InnerSet.this.head;
              InnerSet.this.head = newNode;
              newNode.next.prev=newNode;
            } else if (this.p.next == null) {
              newNode.prev = InnerSet.this.tail;
              newNode.prev.next=newNode;
              InnerSet.this.tail = newNode;
            } else {
              newNode.next=this.p.next;
              this.p.next.prev=newNode;
              this.p.next=newNode;
              newNode.prev=this.p;
              this.p=newNode;
            }
          }
      }

    }


    private class MapIterator extends SetIterator {
        protected MapNode p = OrderedMap.this.head;

        public Iterator<E> iterator() {
          return p.innerSet.iterator();
        }
    }
}
