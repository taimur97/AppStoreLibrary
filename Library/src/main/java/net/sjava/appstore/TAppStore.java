package net.sjava.appstore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * 
 * @author mcsong@gmail.com
 * @date Dec 10, 2014 2:04:18 PM
 * @version 1.0.0
 */
public class TAppStore extends AppStore {
	private static String APP_URL = "http://m.tstore.co.kr/mobilepoc/apps/appsDetail.omp?prodId=";
	
	public static TAppStore newInstance() {
		return new TAppStore();
	}
	
	@Override
	public boolean isInstalled(Context ctx) {
		return isAppInstalled(ctx, PACKAGE_NAME_TSTORE);
	}
    
	@Override
	public void openApp(Context ctx, String uniqueId) {		
		if(isInstalled(ctx)) {
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tstore://PRODUCT_VIEW/" + uniqueId + "/0"));
			ctx.startActivity(intent);
			return;			
		}

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL + uniqueId));
		ctx.startActivity(intent);
	}

	@Override
	public void searchApp(Context ctx, String keyword) {
		String url = "http://www.tstore.co.kr/mobilepoc/search?query="+ keyword;
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		ctx.startActivity(intent);
	}

	//
		
}
