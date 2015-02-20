package miguelmaciel.play.searchwithmusic;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebContent extends Activity {
	String dados;
	WebView myWebView;
	ProgressBar proBar;
	String pesquisa;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_content);
		
		if (android.os.Build.VERSION.SDK_INT >= 11) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		
		pesquisa = getIntent().getStringExtra("search");
		proBar = (ProgressBar) findViewById(R.id.progressBarWeb);
		myWebView = (WebView) findViewById(R.id.webViewBrowser);
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.getSettings().setJavaScriptEnabled(true);

		myWebView.setWebViewClient(new WebViewClient() {
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				proBar.setVisibility(View.VISIBLE);
			}

			public void onPageFinished(WebView view, String url) {
				proBar.setVisibility(View.GONE);
			}
		});
		myWebView.loadUrl(this.getIntent().getDataString());
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
			myWebView.goBack();
			return true;
		}else{
			/*Intent intent = new Intent(this, MainActivity.class);
			intent.putExtra("search", pesquisa);
			startActivity(intent);*/
			Intent intent = new Intent();
			intent.putExtra("search", pesquisa);
			setResult(RESULT_OK, intent);
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			/*Intent intent = new Intent(this, MainActivity.class);
			intent.putExtra("search", pesquisa);
			startActivity(intent);*/
			
			
			final Intent intentX = new Intent();
			intentX.putExtra("search", pesquisa);
			setResult(RESULT_OK, intentX);
			finish();
		}
		return true;
	}
}
