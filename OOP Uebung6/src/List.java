import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;

class List<T extends Android> {
    Map<Integer,T> androids = new LinkedHashMap<Integer,T>();
	
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
    	
    	if(android.kit == null) {
    	    return "Actors not allowed";
    	}

    	current = androids.get(serialnumber);
    	if(current != null) {
    		//android already in list
    		//TODO modify current android
    	    current.modify(android);
    	    return serial+" Successfully updated android";
    	}
    	else {
    		//add new android
    	    android.encode(serialnumber);
    		androids.put(android.serialnumber, android);
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
