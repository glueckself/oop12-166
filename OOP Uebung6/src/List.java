import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

class List<T extends Android> {
    Map<Integer,T> androids = new HashMap<Integer,T>();
	
    public String insert(T android, int serialnumber) {
    	
    	T current;
    	if(android.skin == null) {
    	    return Integer.toString(serialnumber)+" Skin not allowed";
    	}

    	if(android.software == null) {
    	    return Integer.toString(serialnumber)+" Software not allowed";
    	}
    	
    	if(android.software.zertifikat == null) {
    	    return Integer.toString(serialnumber)+" Software not certified";
    	}
    	
    	/*
    	if(android.kit == null) {
    	    return "Actors not allowed";
    	}
    	*/
    	current = androids.get(serialnumber);
    	if(current != null) {
    		//android already in list
    		//TODO modify current android
    		return null;
    	}
    	else {
    		//add new android
    		//TODO apply serial to android when creating in test or when adding to list?
    		android.serialnumber = serialnumber;
    		androids.put(serialnumber, android);
    	}

    	return null;
    } 
	
    public String find(int serialnumber) {
    	String information = null;
    	T current;
    	current = androids.get(serialnumber);
    	if(current == null) return information;
    	else {
    		information = current.toString();
    		return information;
    	}
    }
	
	public Iterator<Map.Entry<Integer,T>> iterator() {
		Iterator<Map.Entry<Integer,T>> entries = androids.entrySet().iterator();
		return entries;
	}
}
