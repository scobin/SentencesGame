package cycres.sentencesgame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

/**
 * 起動画面
 * @author scobin
 *
 */
public class UIs010 extends UIBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uis010);
	}

	
	@Override
	protected void onStart() {
		super.onStart();
		getButton(R.id.btn_game_start).setOnClickListener(this);
	}


	@Override
	protected void onStop() {
		super.onStop();
		getButton(R.id.btn_game_start).setOnClickListener(null);
	}


	@Override
	public void onClick(View v) {
	    switch(v.getId()) {
	    case R.id.btn_game_start:
	    	actClearAndTop(UIs025.class);
	    	break;
	    default:
	    	super.onClick(v);
	    	break;
	    }
	}

}
