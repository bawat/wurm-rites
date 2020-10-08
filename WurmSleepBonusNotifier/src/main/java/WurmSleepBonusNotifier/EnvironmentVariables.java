package WurmSleepBonusNotifier;

import java.util.function.Supplier;

public enum EnvironmentVariables implements Supplier<String>{
	DISCORD_BOT_TOKEN("WURM_SLEEP_BONUS_NOTIFIER_DISCORD_BOT_TOKEN"),
	TWITTER4J_DEBUG_MODE("twitter4j.debug"),
	TWITTER_OAUTH_ACCESS_TOKEN("twitter4j.oauth.accessToken"),
	TWITTER_OAUTH_ACCESS_TOKEN_SECRET("twitter4j.oauth.accessTokenSecret"),
	TWITTER_OAUTH_CONSUMER_KEY("twitter4j.oauth.consumerKey"),
	TWITTER_OAUTH_CONSUMER_SECRET("twitter4j.oauth.consumerSecret");
	
	private String storedValue;
	private String variableName;
	EnvironmentVariables(String variableName){
		this.variableName = variableName;
		storedValue = System.getenv(variableName);
		checkIfEnvironmentVariableExists();
	}
	
	private void checkIfEnvironmentVariableExists() {
		if(get() == null) {
			System.err.println("Couldn't find the environment variable " + variableName);
			System.exit(-1);
		}
	}
	
	@Override
	public String get() {
		return storedValue;
	}
}
