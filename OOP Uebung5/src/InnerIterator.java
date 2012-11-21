import java.util.Iterator;

interface InnerIterator<E> extends Iterator<E> {
  public void add(E obj);
}
