import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

class List<T extends Android> {
    Map<Integer,T> androids = new HashMap<Integer,T>();
	
    public String insert(T android, int serialnumber) {
    	String serial = Integer.toString(serialnumber);
    	T current;
    	if(android.skin == null) {
    	    return serial+" Skin not allowed";
    	}

    	if(android.software == null) {
    	    return serial+" Software not allowed";
    	}
    	
    	if(android.software.zertifikat == null) {
    	    return serial+" Software not certified";
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
    	    return serial+" Successfully updated android";
    	}
    	else {
    		//add new android
    		//TODO apply serial to android when creating in test or when adding to list?
    		android.serialnumber = serialnumber;
    		androids.put(serialnumber, android);
    		return serial+" Successfully added android";
    	}
    } 
	
    public String find(int serialnumber) {
    	String information = Integer.toString(serialnumber)+" not found";
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
