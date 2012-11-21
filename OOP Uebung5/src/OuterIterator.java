import java.util.Iterator;

interface OuterIterator<T,E> extends Iterator<T> {
  public InnerIterator<E> iterator();
}
