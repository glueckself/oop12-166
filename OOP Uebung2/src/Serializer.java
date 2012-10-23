import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Serializer {
	private Group group = null;
	private static volatile Serializer serializer = null;
	/*private Serializer() {
		
	}*/
	
	public static Serializer get() {
		if(serializer == null){
            synchronized (Serializer.class){
                if (serializer == null) {
                        serializer = new Serializer ();
                }
            }
		}
		return serializer;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	public boolean serialize() {
		try	{
    		FileOutputStream fOut = new FileOutputStream("backup");
    		ObjectOutputStream oOut = new ObjectOutputStream(fOut);   
    		oOut.writeObject(this.group);
    		oOut.close();
		}catch(Exception ex) {
			return false;	
		} 
		return true;
	}
	
	public Group deSerialize() {
		this.group = null;
		try	{
	       	
			ObjectInputStream oIn = new ObjectInputStream(new FileInputStream("backup"));
			this.group = (Group)oIn.readObject();
    		oIn.close();
		}catch(Exception ex) {
			return null;
		} 
		return this.group;
	}
}

