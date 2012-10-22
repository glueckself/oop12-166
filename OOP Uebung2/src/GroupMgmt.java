import java.util.Date;
import java.util.ArrayList;

/**
 * Group Managment.
 *
 * @author Julian Grosshauser
 * @author Srdjan Markovic
 */

final class GroupMgmt {
    /**
     * Get all events or a certain type of event of a group that happen/ed between a period of time.
     *
     * @param group The group that played the events
     * @param startDate Start of time interval
     * @param endDate End of time interval
     * @param eventType Which type of events
     * @return Event[] that contains all requested events
     */
    public static Event[] getEvents(Group group, Date startDate, Date endDate, EventType eventType) {
        Event[] events = group.getEvents();
        ArrayList<Event> retEvent = new ArrayList<Event>();
        Date tmpDate;

        /* error cases */
        if(events == null) return null;
        if(retEvent == null) return null;

        for(Event event : events) {
            tmpDate = event.getDate();
            if(tmpDate == null) continue;

            /* if the date of event is between startDate and endDate, add it */
            if(tmpDate.after(startDate) && tmpDate.before(endDate)) {
                /*
                 * you can choose which type of events should be returned
                 * to differentiate between the events, we use instanceof
                 */
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
     * Calculate sum of salaries/rents of events that happen/ed in a period of time.
     * If the event is a practice, the rent returns a negative value.
     *
     * @param group The group that played the events
     * @param startDate Start of time interval
     * @param endDate End of time interval
     * @param eventType Which type of events
     * @return The calculated sum as a double
     */
    public static double getSum(Group group, Date startDate, Date endDate, EventType eventType) {
        Event[] events = GroupMgmt.getEvents(group, startDate, endDate, eventType);
        double retValue = 0;

        /* if there are no events, we can return 0 */
        if(events == null) return 0;

        for(Event event : events) {
            /* if the event is a practice, we subtract the rent */
            if(event instanceof Practice) {
                retValue -= event.getValue();
                continue;
            }

            retValue += event.getValue();
        }

        return retValue;
    }

    /**
     * Returns all active member of a group.
     *
     * @param group Group to get member of
     * @return Member[] of active members
     */
    public static Member[] getMembersActive(Group group) {
        return getMembersTimestamp(group, new Date());
    }

    /**
     * Returns a array of Member with the members of a group at a specific date/time
     *
     * @param group Group to get member of
     * @param timestamp Date object to use as reference
     *
     * @return Member[] of active members at {@see timestamp}
     */
    public static Member[] getMembersTimestamp(Group group, Date timestamp) {
        Member[] members = group.getMembers();
        ArrayList<Member> retMem = new ArrayList<Member>();
        Date tmpDate;

        if(members == null) return null;
        if(retMem == null) return null;

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
     * @param group Group to search for songs
     * @return Song[] array of currently playable songs
     */
    public static Song[] getSongsActive(Group group) {
        return getSongsTimestamp(group, new Date());
    }

    /**
     * Returns all songs a group can play at a specific moment
     *
     * @param group Group to search for songs
     * @param timestamp Date object of desired moment to use as reference
     * @return Song[] array of playable songs at {@see timestamp}
     */
    public static Song[] getSongsTimestamp(Group group, Date timestamp) {
        Song[] songs = group.getSongs();
        ArrayList<Song> retSong = new ArrayList<Song>();
        Date tmpDate;

        if(songs == null) return null;
        if(retSong == null) return null;

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
