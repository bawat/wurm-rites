package WurmSleepBonusNotifier;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;

public abstract class RiteTweetListener implements twitter4j.StatusListener{

	public void onStatus(Status status) {
    	if(!status.getText().toLowerCase().contains("rite".toLowerCase())) return;
    	
    	onTweetRecieved(status.getUser().getName().toLowerCase().replace("mark macheta", "WO_TestingAccount"), status.getText());
    }
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
    public void onException(Exception ex) {
        ex.printStackTrace();
    }
	@Override
	public void onScrubGeo(long userId, long upToStatusId) {
		System.out.println("Recieved request to delete GEO data: userID " + userId + " upToStatusId " + upToStatusId);
	}
	@Override
	public void onStallWarning(StallWarning warning) {
		System.err.println("There was a stall! Printing message: " + warning.getMessage());
	}
	
	abstract void onTweetRecieved(String sender, String tweet);

}
