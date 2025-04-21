import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;

public class Test {
	
	public static void main(String[] args) {
		
		
		// 1. Get authorised
		// On Android: use AndroidTwitterLogin
		// On the desktop...
		// Make an oauth client (you'll want to change the keys here)
		OAuthSignpostClient oauthClient = new OAuthSignpostClient(OAuthSignpostClient.JTWITTER_OAUTH_KEY,"USLG8ce1GgCOTzmxODYyg",
		                OAuthSignpostClient.JTWITTER_OAUTH_SECRET, "kVhyOG0xhdzwaQEl9sFIIZ59u9ElENxaM0JHGRRvC9xTnsmwqz");
		
		

		String[] accessToken = oauthClient.getAccessToken();
		new OAuthSignpostClient("1497773920052776962-xYbiRODFWIkXyKCvAi3EbFptDFhdXi", "YmHvgQev7DF5i2hLrzyhCVk9s0WeoTeOqDeJgEFZIgY0w",accessToken[0], accessToken[1]);

		// 2. Make a Twitter object
		Twitter twitter = new Twitter("Poutina", oauthClient);
		// Print Daniel Winterstein's status
		System.out.println(twitter.getStatus("winterstein"));
		// Set my status
		twitter.setStatus("Messing about in Java");
		
		
		
		
		
		
		
	}

}
