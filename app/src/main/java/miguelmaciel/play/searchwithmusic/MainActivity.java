package miguelmaciel.play.searchwithmusic;

import java.io.File;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText etSearch;
	TextView tvMusicName;
	ImageButton buttonNext;
	ImageButton buttonPlay;
	ImageButton buttonPrevious;
	ImageButton buttonStop;
	File[] files;
	MediaPlayer myMediaPlayer;
	Context contexto;
	int numMusic = 0;
	int firstTime;
	int numStop;
	String url = "";
	String pesquisa = "";
	Boolean playNextMusic = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		setContentView(R.layout.activity_main);

		etSearch = (EditText) findViewById(R.id.editTextSearch);
		buttonNext = (ImageButton) findViewById(R.id.imageButtonForward);
		buttonPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
		buttonPrevious = (ImageButton) findViewById(R.id.imageButtonBackward);
		buttonStop = (ImageButton) findViewById(R.id.imageButtonStop);
		tvMusicName = (TextView) findViewById(R.id.textViewMusicName);
		contexto = getApplicationContext();
		// Log.d("TAG", "TATA");
		firstTime = 0;
	}

	@Override
	protected void onResume() {
		if (checkPlayList() == true) {
			if (firstTime == 0) {
				myMediaPlayer = new MediaPlayer();
				File mediaStorageDirCount = Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

				String targetPath = mediaStorageDirCount.getAbsolutePath();
				File targetDirector = new File(targetPath);
				files = targetDirector.listFiles();
				if (files.length > 0) {
					tvMusicName.setText(files[numMusic].getName().replace(
							".mp3", ""));
				}
			}
		}

		super.onResume();
	};

	public void searchGoogle(View view) {
		final Intent intent = new Intent(this, WebContent.class);
		AlertDialog levelDialog;
		final CharSequence[] types = { this.getString(R.string.browser),
				this.getString(R.string.activi) };
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(this.getString(R.string.choose));
		builder.setSingleChoiceItems(types, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						switch (item) {
						case 0:
							// English UK
							if (Locale.getDefault().getLanguage().toString()
									.equals("en")
									&& Locale.getDefault().getISO3Country()
											.equals("GBR")) {
								url = "https://www.google.co.uk/search?q="
										+ etSearch.getText().toString();
							}// Spanish
							else if (Locale.getDefault().getLanguage()
									.toString().equals("es")) {
								url = "https://www.google.es/search?q="
										+ etSearch.getText().toString();
							}// Italian
							else if (Locale.getDefault().getLanguage()
									.toString().equals("it")) {
								url = "https://www.google.itk/search?q="
										+ etSearch.getText().toString();
							}// Deutch
							else if (Locale.getDefault().getLanguage()
									.toString().equals("de")) {
								url = "https://www.google.de/search?q="
										+ etSearch.getText().toString();
							}// Portuguese
							else if (Locale.getDefault().getLanguage()
									.toString().equals("pt")) {
								url = "https://www.google.pt/search?q="
										+ etSearch.getText().toString();
							} else {
								url = "https://www.google.com/search?q="
										+ etSearch.getText().toString();
							}
							Intent i = new Intent(Intent.ACTION_VIEW);
							i.setData(Uri.parse(url));
							startActivity(i);
							break;
						case 1:
							if (Locale.getDefault().getLanguage().toString()
									.equals("en")
									&& Locale.getDefault().getISO3Country()
											.equals("GBR")) {
								url = "https://www.google.co.uk/search?q="
										+ etSearch.getText().toString();
							}// Spanish
							else if (Locale.getDefault().getLanguage()
									.toString().equals("es")) {
								url = "https://www.google.es/search?q="
										+ etSearch.getText().toString();
							}// Italian
							else if (Locale.getDefault().getLanguage()
									.toString().equals("it")) {
								url = "https://www.google.itk/search?q="
										+ etSearch.getText().toString();
							}// Deutch
							else if (Locale.getDefault().getLanguage()
									.toString().equals("de")) {
								url = "https://www.google.de/search?q="
										+ etSearch.getText().toString();
							}// Portuguese
							else if (Locale.getDefault().getLanguage()
									.toString().equals("pt")) {
								url = "https://www.google.pt/search?q="
										+ etSearch.getText().toString();
							} else {
								url = "https://www.google.com/search?q="
										+ etSearch.getText().toString();
							}
							intent.setData(Uri.parse(url));
							intent.putExtra("search", etSearch.getText()
									.toString());
							// startActivity(intent);
							startActivityForResult(intent, 0);
							break;
						}
						dialog.dismiss();
					}
				});
		levelDialog = builder.create();
		levelDialog.show();
	}

	public void searchYahoo(View view) {
		final Intent intent = new Intent(this, WebContent.class);
		AlertDialog levelDialog;
		final CharSequence[] types = { this.getString(R.string.browser),
				this.getString(R.string.activi) };
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(this.getString(R.string.choose));
		builder.setSingleChoiceItems(types, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						switch (item) {
						case 0:
							// English UK
							if (Locale.getDefault().getLanguage().toString()
									.equals("en")
									&& Locale.getDefault().getISO3Country()
											.equals("GBR")) {
								url = "http://uk.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}// Spanish
							else if (Locale.getDefault().getLanguage()
									.toString().equals("es")) {
								url = "http://es.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}// Italian
							else if (Locale.getDefault().getLanguage()
									.toString().equals("it")) {
								url = "http://it.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}// Deutch
							else if (Locale.getDefault().getLanguage()
									.toString().equals("de")) {
								url = "http://de.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}// Portuguese Brasil
							else if (Locale.getDefault().getLanguage()
									.toString().equals("pt")) {
								url = "http://br.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							} else {
								url = "http://search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}
							Intent i = new Intent(Intent.ACTION_VIEW);
							i.setData(Uri.parse(url));
							startActivity(i);
							break;
						case 1:
							// English UK
							if (Locale.getDefault().getLanguage().toString()
									.equals("en")
									&& Locale.getDefault().getISO3Country()
											.equals("GBR")) {
								url = "http://uk.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}// Spanish
							else if (Locale.getDefault().getLanguage()
									.toString().equals("es")) {
								url = "http://es.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}// Italian
							else if (Locale.getDefault().getLanguage()
									.toString().equals("it")) {
								url = "http://it.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}// Deutch
							else if (Locale.getDefault().getLanguage()
									.toString().equals("de")) {
								url = "http://de.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}// Portuguese Brasil
							else if (Locale.getDefault().getLanguage()
									.toString().equals("pt")) {
								url = "http://br.search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							} else {
								url = "http://search.yahoo.com/search?p="
										+ etSearch.getText().toString();
							}
							intent.setData(Uri.parse(url));
							intent.putExtra("search", etSearch.getText()
									.toString());
							// startActivity(intent);
							startActivityForResult(intent, 0);
							break;
						}
						dialog.dismiss();
					}
				});
		levelDialog = builder.create();
		levelDialog.show();
	}

	public void searchBing(View view) {
		final Intent intent = new Intent(this, WebContent.class);
		AlertDialog levelDialog;
		final CharSequence[] types = { this.getString(R.string.browser),
				this.getString(R.string.activi) };
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(this.getString(R.string.choose));
		builder.setSingleChoiceItems(types, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						switch (item) {
						case 0:
							url = "http://www.bing.com/search?q="
									+ etSearch.getText().toString()
									+ "&cc="
									+ Locale.getDefault().getLanguage()
											.toString();// Locale.getDefault().getISO3Country().toString();
							Intent i = new Intent(Intent.ACTION_VIEW);
							i.setData(Uri.parse(url));
							startActivity(i);
							break;
						case 1:
							url = "http://www.bing.com/search?q="
									+ etSearch.getText().toString()
									+ "&cc="
									+ Locale.getDefault().getLanguage()
											.toString();// Locale.getDefault().getISO3Country().toString();
							intent.setData(Uri.parse(url));
							intent.putExtra("search", etSearch.getText()
									.toString());
							// startActivity(intent);
							startActivityForResult(intent, 0);
							break;
						}
						dialog.dismiss();
					}
				});
		levelDialog = builder.create();
		levelDialog.show();
	}

	public void searchWiki(View view) {
		final Intent intent = new Intent(this, WebContent.class);
		AlertDialog levelDialog;
		final CharSequence[] types = { this.getString(R.string.browser),
				this.getString(R.string.activi) };
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(this.getString(R.string.choose));
		builder.setSingleChoiceItems(types, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						switch (item) {
						case 0:
							url = "https://"
									+ Locale.getDefault().getLanguage()
											.toString()
									+ ".wikipedia.org/wiki/"
									+ etSearch.getText().toString();
							Intent i = new Intent(Intent.ACTION_VIEW);
							i.setData(Uri.parse(url));
							startActivity(i);
							break;
						case 1:
							url = "https://"
									+ Locale.getDefault().getLanguage()
											.toString()
									+ ".wikipedia.org/wiki/"
									+ etSearch.getText().toString();
							intent.setData(Uri.parse(url));
							intent.putExtra("search", etSearch.getText()
									.toString());
							// startActivity(intent);
							startActivityForResult(intent, 0);
							break;
						}
						dialog.dismiss();
					}
				});
		levelDialog = builder.create();
		levelDialog.show();
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				// A contact was picked. Here we will just display it
				// to the user.
				try {
					pesquisa = data.getStringExtra("search");
					etSearch.setText(pesquisa.toString());
					pesquisa = "";
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public void startPlayer(View view) {
		numStop = 0;
		if (checkPlayList() == true) {
			if (firstTime == 0) {
				if (buttonPlay.getTag().toString().equals("play")) {
					try {
						if (files.length > 0) {
							myMediaPlayer = MediaPlayer.create(this, Uri
									.parse(files[numMusic].getAbsolutePath()));
									
							myMediaPlayer
									.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
										public void onCompletion(
												MediaPlayer mediaPlayer) {
											playNextMusic = true;
											buttonNext.performClick();											
										}
									});
							
							myMediaPlayer.setOnPreparedListener(new OnPreparedListener() { 
						        @Override
						        public void onPrepared(MediaPlayer mp) {
						        	myMediaPlayer.start();
						        }
						    });
							//myMediaPlayer.start();
							buttonPlay.setTag("pause");
							buttonPlay.setImageResource(R.drawable.ic_pause);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					firstTime = 1;
				}
			} else if (firstTime != 0) {
				if (buttonPlay.getTag().toString().equals("play")) {					
					myMediaPlayer.start();
					buttonPlay.setTag("pause");
					buttonPlay.setImageResource(R.drawable.ic_pause);
				} else if (buttonPlay.getTag().toString().equals("pause")) {
					myMediaPlayer.pause();
					buttonPlay.setTag("play");
					buttonPlay.setImageResource(R.drawable.ic_play);
				}
			}
		}
	}

	public void stopMusic(View view) {
		numStop = numStop + 1;
		playNextMusic = false;
		if (checkPlayList() == true) {
			if (numStop == 1) {
				myMediaPlayer.stop();
				myMediaPlayer.release();
			} else if (numStop > 1) {
				numMusic = 0;
				tvMusicName.setText(files[numMusic].getName().replace(".mp3",
						""));
			}
			buttonPlay.setTag("play");
			buttonPlay.setImageResource(R.drawable.ic_play);
			firstTime = 0;
		}
	}

	public void nextMusic(View view) {
		numMusic = numMusic + 1;
		if (checkPlayList() == true) {
			if (numMusic >= files.length) {
				numMusic = 0;
			}
			if (firstTime == 0) {
				tvMusicName.setText(files[numMusic].getName().replace(".mp3",
						""));
			} else if (firstTime != 0 && myMediaPlayer.isPlaying() == true) {
				myMediaPlayer.release();
				myMediaPlayer = MediaPlayer.create(this,
						Uri.parse(files[numMusic].getAbsolutePath()));

			/*	try {
					myMediaPlayer.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/

				myMediaPlayer
						.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
							public void onCompletion(MediaPlayer mediaPlayer) {
								playNextMusic = true;
								buttonNext.performClick();	
							}
						});

				tvMusicName.setText(files[numMusic].getName().replace(".mp3",
						""));

				myMediaPlayer.setOnPreparedListener(new OnPreparedListener() { 
			        @Override
			        public void onPrepared(MediaPlayer mp) {
			        	myMediaPlayer.start();
			        }
			    });
				//myMediaPlayer.start();
				buttonPlay.setTag("pause");
				buttonPlay.setImageResource(R.drawable.ic_pause);
			} else if (firstTime != 0 && myMediaPlayer.isPlaying() == false && playNextMusic == true) {
				myMediaPlayer.release();
				myMediaPlayer = MediaPlayer.create(this,
						Uri.parse(files[numMusic].getAbsolutePath()));
			/*	try {
					myMediaPlayer.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/

				myMediaPlayer
						.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
							public void onCompletion(MediaPlayer mediaPlayer) {
								playNextMusic = true;
								buttonNext.performClick();	
							}
						});

				tvMusicName.setText(files[numMusic].getName().replace(".mp3",
						""));

				myMediaPlayer.setOnPreparedListener(new OnPreparedListener() { 
			        @Override
			        public void onPrepared(MediaPlayer mp) {
			        	myMediaPlayer.start();
			        }
			    });
				//myMediaPlayer.start();
				buttonPlay.setTag("pause");
				buttonPlay.setImageResource(R.drawable.ic_pause);
			} else if (firstTime != 0 && myMediaPlayer.isPlaying() == false && playNextMusic == false) {
				myMediaPlayer.release();
				myMediaPlayer = MediaPlayer.create(this,
						Uri.parse(files[numMusic].getAbsolutePath()));				

				tvMusicName.setText(files[numMusic].getName().replace(".mp3",
						""));				
			}
		}
	}

	public void previousMusic(View view) {
		numMusic = numMusic - 1;
		if (checkPlayList() == true) {
			if (numMusic < 0) {
				numMusic = files.length - 1;
			}
			if (firstTime == 0) {
				tvMusicName.setText(files[numMusic].getName().replace(".mp3",
						""));
			} else if (firstTime != 0 && myMediaPlayer.isPlaying() == true) {
				myMediaPlayer.release();
				myMediaPlayer = MediaPlayer.create(this,
						Uri.parse(files[numMusic].getAbsolutePath()));
				myMediaPlayer
						.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
							public void onCompletion(MediaPlayer mediaPlayer) {
								playNextMusic = true;
								buttonNext.performClick();	
							}
						});
				tvMusicName.setText(files[numMusic].getName().replace(".mp3",
						""));
				myMediaPlayer.setOnPreparedListener(new OnPreparedListener() { 
			        @Override
			        public void onPrepared(MediaPlayer mp) {
			        	myMediaPlayer.start();
			        }
			    });
				//myMediaPlayer.start();
				buttonPlay.setTag("pause");
				buttonPlay.setImageResource(R.drawable.ic_pause);
			} else if (firstTime != 0 && myMediaPlayer.isPlaying() == false && playNextMusic == true) {
				myMediaPlayer.release();
				myMediaPlayer = MediaPlayer.create(this,
						Uri.parse(files[numMusic].getAbsolutePath()));
				myMediaPlayer
						.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
							public void onCompletion(MediaPlayer mediaPlayer) {
								playNextMusic = true;
								buttonNext.performClick();	
							}
						});
				tvMusicName.setText(files[numMusic].getName().replace(".mp3",
						""));
				myMediaPlayer.setOnPreparedListener(new OnPreparedListener() { 
			        @Override
			        public void onPrepared(MediaPlayer mp) {
			        	myMediaPlayer.start();
			        }
			    });
				//myMediaPlayer.start();
				buttonPlay.setTag("pause");
				buttonPlay.setImageResource(R.drawable.ic_pause);
			} else if (firstTime != 0 && myMediaPlayer.isPlaying() == false && playNextMusic == false) {
				myMediaPlayer.release();
				myMediaPlayer = MediaPlayer.create(this,
						Uri.parse(files[numMusic].getAbsolutePath()));				
				tvMusicName.setText(files[numMusic].getName().replace(".mp3",
						""));				
			}
		}
	}

	public boolean checkPlayList() {
		boolean haveMusic = false;
		File mediaStorageDirCount = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

		String targetPath = mediaStorageDirCount.getAbsolutePath();
		File targetDirector = new File(targetPath);
		files = targetDirector.listFiles();
		if (files != null) {
			if (files.length > 0) {
				haveMusic = true;
			}
		}
		return haveMusic;
	}

	@Override
	public void onBackPressed() {
		moveTaskToBack(true);
	}
}
