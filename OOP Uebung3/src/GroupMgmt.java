import java.util.Date;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 * BAD: This class is a mix of discontiguous methods. It would be better to
 * divide different parts of it in seperate classes, that would improve the
 * class coherence.
 *
 * @author Julian Grosshauser
 * @author Srdjan Markovic
 */

final class GroupMgmt {
    /**
     * @param group != null [precondition]
     * @return All events of type eventType belonging to group, between
     * startDate and endDate, or null if there are no events [postcondditon]

     */
    public static Event[] getEvents(Group group, Date startDate, Date endDate,
	    EventType eventType) {
        Event[] events = group.getEvents();
        ArrayList<Event> retEvent = new ArrayList<Event>();
        Date tmpDate;

        if(events == null) return null;

        for(Event event : events) {
            tmpDate = event.getDate();
            if(tmpDate == null) continue;

            if(tmpDate.after(startDate) && tmpDate.before(endDate)) {
                switch(eventType) {
                case ALL:
                    retEvent.add(event);
                    break;

                case PRACTICE:
                    if(event instanceof Practice) {
                        retEvent.add(event);
                    }

                    break;

                case PERFORMANCE:
                    if(event instanceof Performance) {
                        retEvent.add(event);
                    }

                    break;

                default:
                    break;
                }
            }
        }

        return retEvent.toArray(new Event[retEvent.size()]);
    }

    /**
     * @param group != null [precondition]
     * ERROR: group != null isn't checked.
     * @return The calculated sum of all finances belonging to group, between 
     * startDate and endDate. If it's a spending, it's value will be
     * subtracted. [postcondition]
     */
    public static BigDecimal getSum(Group group, Date startDate, Date endDate) {
        BigDecimal returnValue = new BigDecimal("0");

        Finance[] finances = group.getFinances();

        if(finances == null) {
            return returnValue;
        }

        for(Finance finance : finances) {
            if(finance.getDate().after(startDate) &&
                    finance.getDate().before(endDate)) {

                if(finance instanceof Spending) {
                    returnValue = returnValue.subtract(finance.getValue());
                } else {
                    returnValue = returnValue.add(finance.getValue());
                }
            }
        }

        return returnValue;
    }

    /**
     * @param group != null [precondition]
     * ERROR: group != null isn't checked.
     * @param filter != null [precondition]
     * ERROR: filter != null isn't checked.
     * @return The calculated sum of all finances belonging to group, between 
     * startDate and endDate. finances will be filtered by filter.
     * [postcondition]
     */
    public static BigDecimal getSum(Group group, Date startDate, Date endDate,
                                    Filter filter) {

        BigDecimal returnValue = new BigDecimal("0");
        ArrayList<Finance> selectedFinances = new ArrayList<Finance>();

        Finance[] finances = group.getFinances();

        if(finances == null) {
            return returnValue;
        }

        for(Finance finance : finances) {
            if(finance.getDate().after(startDate) &&
                    finance.getDate().before(endDate)) {

                selectedFinances.add(finance);
            }
        }

        return filter.filter(selectedFinances.toArray(new Finance[selectedFinances.size()]));
    }

    /**
     * Returns all active member of a group.
     *
     * @param group Group to get member of, group != null [precondition]
     * @return Member[] of active members [postcondition]
     *
     * @author Srdjan Markovic
     */
    public static Member[] getMembersActive(Group group) {
        return getMembersTimestamp(group, new Date());
    }

    /**
     * Returns a array of Member with the members of a group at a specific date/time
     *
     * @param group Group to get member of, group != null [precondition]
     * @param timestamp Date object to use as reference, timestamp != null [precondition]
     *
     * @return Member[] of active members at {@see timestamp} [postcondition]
     *
     * @author Srdjan Markovic
     */
    public static Member[] getMembersTimestamp(Group group, Date timestamp) {
        Member[] members = group.getMembers();
        ArrayList<Member> retMem = new ArrayList<Member>();
        Date tmpDate;

        if(members == null) return null;

        for(Member mem : members) {
            tmpDate = mem.getJoinDate();
            if(tmpDate == null) continue;

            if(mem.getJoinDate().compareTo(timestamp) > 0)
                continue;

            tmpDate = mem.getLeftDate();

            if(tmpDate == null) { //joined, but not left yet -> we can add the member.
                retMem.add(mem);
                continue;
            }

            if(tmpDate.compareTo(timestamp) <= 0)
                continue;

            retMem.add(mem);
        }

        return retMem.toArray(new Member[retMem.size()]);
    }

    /**
     * Returns all songs a group currently can play
     *
     * @param group Group to search for songs, group != null [precondition]
     * @return Song[] array of currently playable songs [postcondition]
     *
     * @author Srdjan Markovic
     */
    public static Song[] getSongsActive(Group group) {
        return getSongsTimestamp(group, new Date());
    }

    /**
     * Returns all songs a group can play at a specific moment
     *
     * @param group Group to search for songs, group != null [precondition]
     * @param timestamp Date object of desired moment to use as reference, timestamp != null [precondition]
     * @return Song[] array of playable songs at {@see timestamp} [postcondition]
     *
     * @author Srdjan Markovic
     */
    public static Song[] getSongsTimestamp(Group group, Date timestamp) {
        Song[] songs = group.getSongs();
        ArrayList<Song> retSong = new ArrayList<Song>();
        Date tmpDate;

        if(songs == null) return null;

        for(Song song: songs) {
            tmpDate = song.getReleaseDate();
            if(tmpDate == null) continue;

            if(tmpDate.compareTo(timestamp) > 0)
                continue;

            tmpDate = song.getDiscardedDate();
            if(tmpDate == null) {
                retSong.add(song);
                continue;
            }

            if(tmpDate.compareTo(timestamp) <= 0)
                continue;

            retSong.add(song);
        }

        return retSong.toArray(new Song[retSong.size()]);
    }
}
