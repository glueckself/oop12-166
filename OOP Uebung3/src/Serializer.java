import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Serializes/Deserializes the group to provide/get backup information
 *
 * @author Alexander Huber
 */
public class Serializer {
    private Group group = null;
    private static volatile Serializer serializer = null;

    /**
     * @return single instance Serializer object [postcondition]
     */
    public static Serializer get() {
        if(serializer == null) {
            synchronized (Serializer.class) {
                if (serializer == null) {
                    serializer = new Serializer ();
                }
            }
        }
        return serializer;
    }

    /**
     * sets the group to be serialized [postcondition]
     * must be called before serialize() [client-controlled history-constraint]
     * @param group != null [precondition]
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * serializes a group to a backup-file [postcondition]
     * setGroup(..) must be called before [client-controlled history-constraint]
     */
    public boolean serialize() {
    	//BAD: should check if group is still null
        try	{
            FileOutputStream fOut = new FileOutputStream("backup");
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(this.group);
            oOut.close();
        } catch(Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * deserializes a group from a backup-file and returns it [postcondition]
     * returns null if no backup-file exists or it's broken [postcondition]
     */
    public Group deSerialize() {
        this.group = null;
        try	{

            ObjectInputStream oIn = new ObjectInputStream(new FileInputStream("backup"));
            this.group = (Group)oIn.readObject();
            oIn.close();
        } catch(Exception ex) {
            return null;
        }
        return this.group;
    }
}
