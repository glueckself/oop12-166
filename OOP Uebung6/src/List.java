import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;

class List<T extends Android> {
    Map<Integer,Android> androids = new LinkedHashMap<Integer,Android>();
	
    public String insert(T android, int serialnumber) {
    	String serial = Integer.toString(serialnumber);
    	Android current;
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
    	    return serial+" Actors not allowed";
    	}

    	current = androids.get(serialnumber);
    	if(current != null) {
    		//android already in list
    		//TODO modify current android
    	    Android modified = android.modify(current);
    	    Zertifikat zertifikat = android.software.zertifikat.modify(current.software.zertifikat);
    	    if(modified == null || zertifikat == null) return serial+" Couldn't modify android";
    	    else {
    	        modified.encode(serialnumber);
    	        androids.put(modified.serialnumber, modified);
    	    }
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
    	Android current;
    	current = androids.get(serialnumber);
    	if(current == null) return information;
    	else {
    		information = current.toString();
    		return information;
    	}
    }
	
	public Iterator<Map.Entry<Integer,Android>> iterator() {
		Iterator<Map.Entry<Integer,Android>> entries = androids.entrySet().iterator();
		return entries;
	}
}
