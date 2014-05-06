package cycres.sentencesgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.R.integer;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * ゲームの進行画面
 * @author scobin
 *
 */
public class UIs025 extends UIBase {

	private int ansSortNum;
	
	private String[] txtContent;
	
	private int[][] bp_matrix;
	
	private int index = 1;
	
	private int bp_num = 3;
	
	private String ans="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uis025);
		ansSortNum = 0;
		findViewById(R.id.tr_s025_ans_row_1).setTag(false);
		findViewById(R.id.tr_s025_ans_row_2).setTag(false);
		findViewById(R.id.tr_s025_ans_row_3).setTag(false);
		findViewById(R.id.tr_s025_ans_row_4).setTag(false);
		findViewById(R.id.tr_s025_ans_row_5).setTag(false);
		//
		txtContent = GameContent.konayuki.split("/n");
		bp_matrix = new int[txtContent.length][];
		for(int i=0;i<bp_matrix.length;i++) {
			bp_matrix[i] = AddMinMax(BubSorting(getMutiRandom(bp_num, 1, txtContent[i].length()-2)),0,txtContent[i].length());
			//Log.v("test", "i=" + String.valueOf(i) + ": " + String.valueOf(bp_matrix[i][0]) + "," + String.valueOf(bp_matrix[i][1]) + "," + String.valueOf(bp_matrix[i][2]));
			
		}
		//ゲームを開始する。
		GameProcessing();
	}

	@Override
	protected void onStart() {
		super.onStart();
		//listener
		findViewById(R.id.btn_s025_confirm).setOnClickListener(this);
		findViewById(R.id.tr_s025_ans_row_1).setOnClickListener(this);
		findViewById(R.id.tr_s025_ans_row_2).setOnClickListener(this);
		findViewById(R.id.tr_s025_ans_row_3).setOnClickListener(this);
		findViewById(R.id.tr_s025_ans_row_4).setOnClickListener(this);
		findViewById(R.id.tr_s025_ans_row_5).setOnClickListener(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		findViewById(R.id.btn_s025_confirm).setOnClickListener(null);
		findViewById(R.id.tr_s025_ans_row_1).setOnClickListener(null);
		findViewById(R.id.tr_s025_ans_row_2).setOnClickListener(null);
		findViewById(R.id.tr_s025_ans_row_3).setOnClickListener(null);
		findViewById(R.id.tr_s025_ans_row_4).setOnClickListener(null);
		findViewById(R.id.tr_s025_ans_row_5).setOnClickListener(null);
	}

	@Override
	public void onClick(View v) {
		int deleteLength;
		switch(v.getId()) {
		case R.id.tr_s025_ans_row_1:
			if(!(Boolean) v.getTag()) {
				//選択していない
				v.setTag(true);
				ans += getTextView(R.id.txt_s025_ans_row_1).getText().toString();
				ansSortNum++;
				getTextView(R.id.txt_s025_ans_no_row_1).setText(String.valueOf(ansSortNum));
				findViewById(R.id.tr_s025_ans_row_1).setBackgroundColor(getResources().getColor(R.color.darkgray));
			}
			else {
				//選択している
				if(getTextView(R.id.txt_s025_ans_no_row_1).getText().toString().equals(String.valueOf(ansSortNum))) {
					//最後の選択番号
					v.setTag(false);
					deleteLength = getTextView(R.id.txt_s025_ans_row_1).getText().length();
					ans = ans.substring(0, ans.length()-deleteLength);
					getTextView(R.id.txt_s025_ans_no_row_1).setText("");
					findViewById(R.id.tr_s025_ans_row_1).setBackgroundColor(getResources().getColor(R.color.orange));
					ansSortNum--;
				}
			}
			getTextView(R.id.txt_s025_ques_2).setText(ans);
			break;
		case R.id.tr_s025_ans_row_2:
			if(!(Boolean) v.getTag()) {
				//選択していない場合
				v.setTag(true);
				ans += getTextView(R.id.txt_s025_ans_row_2).getText().toString();
				ansSortNum++;
				getTextView(R.id.txt_s025_ans_no_row_2).setText(String.valueOf(ansSortNum));
				findViewById(R.id.tr_s025_ans_row_2).setBackgroundColor(getResources().getColor(R.color.darkgray));
			}
			else {
				if(getTextView(R.id.txt_s025_ans_no_row_2).getText().toString().equals(String.valueOf(ansSortNum))) {
					//最後の選択番号
					v.setTag(false);
					deleteLength = getTextView(R.id.txt_s025_ans_row_2).getText().length();
					ans = ans.substring(0, ans.length()-deleteLength);
					getTextView(R.id.txt_s025_ans_no_row_2).setText("");
					findViewById(R.id.tr_s025_ans_row_2).setBackgroundColor(getResources().getColor(R.color.orange));
					ansSortNum--;
				}
			}
			getTextView(R.id.txt_s025_ques_2).setText(ans);
			break;
		case R.id.tr_s025_ans_row_3:
			if(!(Boolean) v.getTag()) {
				//選択していない場合
				v.setTag(true);
				ans += getTextView(R.id.txt_s025_ans_row_3).getText().toString();
				ansSortNum++;
				getTextView(R.id.txt_s025_ans_no_row_3).setText(String.valueOf(ansSortNum));
				findViewById(R.id.tr_s025_ans_row_3).setBackgroundColor(getResources().getColor(R.color.darkgray));
			}
			else {
				if(getTextView(R.id.txt_s025_ans_no_row_3).getText().toString().equals(String.valueOf(ansSortNum))) {
					//最後の選択番号
					v.setTag(false);
					deleteLength = getTextView(R.id.txt_s025_ans_row_3).getText().length();
					ans = ans.substring(0, ans.length()-deleteLength);
					getTextView(R.id.txt_s025_ans_no_row_3).setText("");
					findViewById(R.id.tr_s025_ans_row_3).setBackgroundColor(getResources().getColor(R.color.orange));
					ansSortNum--;
				}
			}
			getTextView(R.id.txt_s025_ques_2).setText(ans);
			break;
		case R.id.tr_s025_ans_row_4:
			if(!(Boolean) v.getTag()) {
				//選択していない場合
				v.setTag(true);
				ans += getTextView(R.id.txt_s025_ans_row_4).getText().toString();
				ansSortNum++;
				getTextView(R.id.txt_s025_ans_no_row_4).setText(String.valueOf(ansSortNum));
				findViewById(R.id.tr_s025_ans_row_4).setBackgroundColor(getResources().getColor(R.color.darkgray));
			}
			else {
				if(getTextView(R.id.txt_s025_ans_no_row_4).getText().toString().equals(String.valueOf(ansSortNum))) {
					//最後の選択番号
					v.setTag(false);
					deleteLength = getTextView(R.id.txt_s025_ans_row_4).getText().length();
					ans = ans.substring(0, ans.length()-deleteLength);
					getTextView(R.id.txt_s025_ans_no_row_4).setText("");
					findViewById(R.id.tr_s025_ans_row_4).setBackgroundColor(getResources().getColor(R.color.orange));
					ansSortNum--;
				}
			}
			getTextView(R.id.txt_s025_ques_2).setText(ans);
			break;
		case R.id.tr_s025_ans_row_5:
			if(!(Boolean) v.getTag()) {
				//選択していない場合
				v.setTag(true);
				ans += getTextView(R.id.txt_s025_ans_row_5).getText().toString();
				ansSortNum++;
				getTextView(R.id.txt_s025_ans_no_row_5).setText(String.valueOf(ansSortNum));
				findViewById(R.id.tr_s025_ans_row_5).setBackgroundColor(getResources().getColor(R.color.darkgray));
			}
			else {
				if(getTextView(R.id.txt_s025_ans_no_row_5).getText().toString().equals(String.valueOf(ansSortNum))) {
					//最後の選択番号
					v.setTag(false);
					deleteLength = getTextView(R.id.txt_s025_ans_row_5).getText().length();
					ans = ans.substring(0, ans.length()-deleteLength);
					getTextView(R.id.txt_s025_ans_no_row_5).setText("");
					findViewById(R.id.tr_s025_ans_row_5).setBackgroundColor(getResources().getColor(R.color.orange));
					ansSortNum--;
				}
			}
			getTextView(R.id.txt_s025_ques_2).setText(ans);
			break;
		case R.id.btn_s025_confirm:
			if(txtContent[index].equals(ans)) {
				//正解
				index += 2;
				ans = new String();
				if(index > txtContent.length) {
					//ゲーム終了
					Builder builder = new AlertDialog.Builder(mMyApp.getApplicationContext());
					builder.setTitle("Completed!!");
					builder.setMessage("Congratulation!! You finished this mission.");
					builder.setPositiveButton("Back to the title.", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							actClearAndTop(UIs010.class);
							
						}
					});
				}
				else {
					//次のテーマ
					findViewById(R.id.tr_s025_ans_row_1).setBackgroundColor(getResources().getColor(R.color.orange));
					getTextView(R.id.txt_s025_ans_no_row_1).setText("");
					findViewById(R.id.tr_s025_ans_row_2).setBackgroundColor(getResources().getColor(R.color.orange));
					getTextView(R.id.txt_s025_ans_no_row_2).setText("");
					findViewById(R.id.tr_s025_ans_row_3).setBackgroundColor(getResources().getColor(R.color.orange));
					getTextView(R.id.txt_s025_ans_no_row_3).setText("");
					findViewById(R.id.tr_s025_ans_row_4).setBackgroundColor(getResources().getColor(R.color.orange));
					getTextView(R.id.txt_s025_ans_no_row_4).setText("");
					findViewById(R.id.tr_s025_ans_row_5).setBackgroundColor(getResources().getColor(R.color.orange));
					getTextView(R.id.txt_s025_ans_no_row_5).setText("");
					findViewById(R.id.tr_s025_ans_row_1).setTag(false);
					findViewById(R.id.tr_s025_ans_row_2).setTag(false);
					findViewById(R.id.tr_s025_ans_row_3).setTag(false);
					findViewById(R.id.tr_s025_ans_row_4).setTag(false);
					findViewById(R.id.tr_s025_ans_row_5).setTag(false);
					ansSortNum = 0;
					ans = "";
					getTextView(R.id.txt_s025_ques_2).setText("");
					GameProcessing();
				}
			}
			else {
				//不正解
				Toast.makeText(mMyApp.getApplicationContext(), "Answer is wrong. Try it again.", Toast.LENGTH_SHORT).show();
			}
		default:
			super.onClick(v);
			break;
		}
	}

	/**
	 * 単一乱数の作成
	 * @param min
	 * :最小値
	 * @param max
	 * :最大値
	 * @return
	 */
	private int getRandom(int min,int max){
        long seed = System.currentTimeMillis();
        Random r = new Random(); 
        r.setSeed(seed);        
        return (min + r.nextInt(max-min+1));
    }
	
	/**
	 * 複数乱数の作成(乱数を重複しない)
	 * @param muti_num
	 * :乱数の数目
	 * @param min
	 * :最小値
	 * @param max
	 * :最小値
	 * @return
	 */
	private int[] getMutiRandom(int muti_num,int min,int max) {
		int[] p = new int[muti_num];
		int i = 0;
		int random;
		int save;
		while(i<muti_num) {
			random = getRandom(min,max);
			if(i==0) {
				p[i] = random;
				i++;
			}
			else {
				save = 1;
				for(int j=0;j<i;j++) {
					if(random == p[j]) {
						save = 0;
					}
				}
				if(save == 1) {
					p[i] = random;
					i++;
				}
				
			}
		}
		return p;
	}
	
	/**
	 * 数値大小のソート処理
	 * @param p
	 * 数値マトリクス
	 * @return
	 */
	private int[] BubSorting(int[] p) {
		int tmp;
		for(int j=p.length-1;j>0;j--) {
			for(int k=0;k<j;k++) {
				if(p[k]>p[k+1]){
					tmp = p[k+1];
					p[k+1] = p[k];
					p[k] = tmp;
				}
			}
			
		}
		return p;
	}
	
	/**
	 * 数値マトリクスの先頭にminを、最後にmaxを追加する。
	 * @param p
	 * 数値マトリクス
	 * @param min
	 * @param max
	 * @return
	 */
	private int[] AddMinMax(int[] p,int min, int max) {
		int[] result = new int[p.length+2];
		result[0] = min;
		result[p.length+1] = max;
		for(int i=1;i<p.length+1;i++) {
			result[i] = p[i-1];
		}
		return result;
	}

	/**
	 * 範囲内の数値マトリクスの作成
	 * @param min
	 * :最小値
	 * @param max
	 * ：最大値
	 * @return
	 */
	private int[] RandomSequence(int min, int max) {
		int[] result = new int[Math.abs(min-max)+1];
		List<Integer> list = new ArrayList<Integer>();
		int rand;
		for(int i=0;i<result.length;i++) {
			list.add(min + i);  
		}
		for(int i=0;i<result.length;i++) {
			rand = getRandom(0,list.size()-1);
			result[i] = list.get(rand);
			list.remove(rand);
		}
		return result;
	}
	
	/**
	 * ゲーム画面の表示
	 */
	private void GameProcessing() {
		//テーマの表示
		getTextView(R.id.txt_s025_ques_1).setText(txtContent[index-1]);
		if(index+1 <= txtContent.length) {
			getTextView(R.id.txt_s025_ques_3).setText(txtContent[index+1]);
		}
		//選択肢の表示
		String ansStr = "";
		int[] randSequence = RandomSequence(0,3);
		for(int i=0;i<bp_matrix[index].length-1;i++) {
			ansStr = txtContent[index].substring(bp_matrix[index][i], bp_matrix[index][i+1]);
			switch(randSequence[i]){
			case 0:
				getTextView(R.id.txt_s025_ans_row_1).setText(ansStr);
				break;
			case 1:
				getTextView(R.id.txt_s025_ans_row_2).setText(ansStr);
				break;
			case 2:
				getTextView(R.id.txt_s025_ans_row_3).setText(ansStr);
				break;
			case 3:
				getTextView(R.id.txt_s025_ans_row_4).setText(ansStr);
				break;
			case 4:
				getTextView(R.id.txt_s025_ans_row_5).setText(ansStr);
				break;
			default:
				break;
			}
			
			
		}

		
	}
}
