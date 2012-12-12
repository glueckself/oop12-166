import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

@Target({TYPE, METHOD, CONSTRUCTOR} )
@Retention( RetentionPolicy.RUNTIME )
@interface Member {
    String   value();
}
