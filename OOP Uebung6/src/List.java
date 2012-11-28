import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;

class List implements Iterable<Android> {
    Map<Integer,Android> androids = new LinkedHashMap<Integer,Android>();
	
    /**
     * Insert android into list.
     * Checks if every rule of the regulation is followed.
     * If an android part breaks a rule, the android is not inserted into the
     * list.
     * If an android with the same serialnumber already exists in the list,
     * it checks if the android can be modified to the new one.
     * 
     * @param android Android to insert
     * @param serialnumber serialnumber to use
     * @return String null if the android is inserted, otherwise a String
     * containing an error code
     */
    public String insert(Android android, int serialnumber) {
    	String serial = Integer.toString(serialnumber);
    	Android current;
	
	//check rules
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
	
    /**
     * Searches for android with specified serialnumber in list
     *
     * @param serialnumber serialnumber to search for
     * @return String "serialnumber not found" if android with this
     * serialnumber is not in list, otherwise a String containing information
     * about the found android
     */
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
	
    protected class ListIterator implements Iterator<Android> {
	Iterator<Map.Entry<Integer,Android>> entries = androids.entrySet().iterator();

	public boolean hasNext() {
	    return entries.hasNext();
	}

	public Android next() {
	    return entries.next().getValue();
	}
	
	public void remove() {
	    
	}
    }

    public Iterator<Android> iterator() {
    return new ListIterator();
    }
}
