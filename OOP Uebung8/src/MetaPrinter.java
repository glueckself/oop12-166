import java.lang.reflect.Method;

@Member("Alex Huber")
public class MetaPrinter {
    @Member("Alex Huber")
    public void print(Object obj) {
        System.out.println("-------------------------------------");
        if (obj.getClass().isAnnotationPresent(Member.class)) {
            System.out.println("Class ["+obj.getClass().getName()+"] "+obj.getClass().getAnnotation(Member.class).value());
            System.out.println("Methods:");
            for(Method method : obj.getClass().getMethods()) {
                if (method.isAnnotationPresent(Member.class)) {
                    System.out.println("["+method.getName()+"] "+method.getAnnotation(Member.class).value());
                }
            }
        }
    }

}
