import java.util.Date;

/**
 * Tests all song-specific functions of a group object
 *
 *
 * @author Srdjan Markovic
 */
class Songtest implements ModuleTest {
    private final String moduleName = "Songtest";
    private String errorMessage = "";

    private Group _group;

    //Format: Songname, Duration, Release
    private final String testData[][] = {
        {"Testsong","04:13","21.02.2008"},
        {"Testsong 2","02:15","15.08.2010"},
        {"Testsong 3","05:00","16.07.2012"},
    };

    private String deletedSongs[];

    /**
     * Creates a new Songtest object.
     * 
     * @param group Group object to run test on, group != null [precondition]
     */
    public Songtest(Group group) {
        _group=group;
        deletedSongs = new String[testData.length];
    }

    /**
     * Returns name of this module test.
     *
     * moduleName != "", moduleName != null [invariant]
     *
     * @return Module name, getName() != null, getName() != "" [postcondition]
     */
    public String getName() {
        return moduleName;
    }

    /**
     * Returns a string explaining why the test failed.
     *
     * Test has failed [precondition].
     *
     * @return Error message. [postcondition]
     */
    public String getMessage() {
        return errorMessage;
    }

    /**
     * Executes the test.
     * NOTE: Tests are:
     * * Check if all songs are registered.
     * * Check if GroupMgmt hides removed songs.
     * * Check if GroupMgmt hides songs not matching a timestamp.
     *
     * group != null [invariant]
     * Modified group object by test process [postcondition]
     *
     * @return true if successful, false if not [postcondition]
     */
    public boolean runTest() {
        Song testSongs[] = new Song[testData.length];
        Song result[];

        if(_group == null) {
            errorMessage="Group is null.";
            return false;
        }

        for(int i=0; i<testSongs.length; i++) {
            testSongs[i]=new Song(testData[i][0],
                                  DateFormatter.toDate(testData[i][1],DateType.Song),
                                  DateFormatter.toDate(testData[i][2],DateType.Date));

            if(_group.addSong(testSongs[i]) == false) {
                errorMessage="Group did not add song";
                return false;
            }
        }

        if(_group.addSong(null)) {
            errorMessage="Group added empty song";
            return false;
        }

        result = _group.getSongs();

        if(verifyResult(result,new int[] {0,1,2})) {
            errorMessage="All songs: "+errorMessage;
            return false;
        }

        _group.removeSong(testData[0][0]);
        deletedSongs[0]=DateFormatter.toString(new Date(),DateType.Date);

        result=GroupMgmt.getSongsActive(_group);
        if(verifyResult(result,new int[] {1,2})) {
            errorMessage="Active songs: "+errorMessage;
            return false;
        }

        result=GroupMgmt.getSongsTimestamp(_group,DateFormatter.toDate("15.12.2011",DateType.Date));
        if(verifyResult(result,new int[] {0,1})) {
            errorMessage="Timestamp songs: "+errorMessage;
            return false;
        }

        return true;

    }

    /**
     * Compares two Song arrays to verify result.
     * NOTE:
     * The arrays doesn't need to be sorted.
     * The function uses false as "successful"-value to simplify usage, e.g.
     * "if(verifyResult(...)) ..." instead of "if(!verifyResult(...)) ..."
     *
     * @param result Returned value (e.g. from _group.*), result != null [precondition]
     * @param expectedValue Integer array of indicies of testData/deletedSongs to compare to, expectedValue != null [precondition]
     *
     * @return false if arrays have the same elements, true if not. [postcondition]
     */
    private boolean verifyResult(Song[] result, int[] expectedValue) {
        boolean success;
        Date discardedDate;

        if(result.length != expectedValue.length) {
            errorMessage="group.getSongs length different than expected"
                         +" (is: "+ result.length+ ", expected: " +expectedValue.length +").";
            return true;
        }

        for(int i=0; i<expectedValue.length; i++) {
            success=false;

            for(int j=0; j<result.length; j++) {
                if(!result[j].getName().equals(testData[expectedValue[i]][0])) continue;
                if(!DateFormatter.compare(result[j].getDuration(),testData[expectedValue[i]][1],DateType.Song)) continue;
                if(!DateFormatter.compare(result[j].getReleaseDate(),testData[expectedValue[i]][2],DateType.Date)) continue;

                //NOTE: if we're here, we found the song we're looking for.

                discardedDate = result[j].getDiscardedDate();

                if(deletedSongs[expectedValue[i]]==null) {
                    if(discardedDate != null) {
                        errorMessage="unexpected discardedDate on result #"+j;
                        return true;
                    }
                } else {
                    if(discardedDate == null) {
                        errorMessage="expected discardedDate but not found on result #"+j;
                        return true;
                    }

                    if(!DateFormatter.compare(discardedDate,deletedSongs[expectedValue[i]],DateType.Date)) {
                        errorMessage="discardedDate mismatch on result #"+j;
                        return true;
                    }
                }
                success=true;
            }

            if(success) continue;

            errorMessage="Song #"+i+" not found.";
            return true;
        }

        return false;
    }
}

