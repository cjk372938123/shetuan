package com.example.mysoftware.controller.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import android.widget.Toolbar;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.adapter.NoteAdapter;
import com.example.mysoftware.controller.entity.Note;
import com.example.mysoftware.model.dao.CRUD;
import com.example.mysoftware.model.db.NoteDatabase;


import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class EditMainActivity extends Activity implements AdapterView.OnItemClickListener {

    private Button btn;
    private NoteDatabase dbHelper;
    private Context context = this;
    private TextView tv;
    private ListView lv;
    private NoteAdapter adapter;
    private List<Note> noteList = new ArrayList<>();
    private Toolbar mToolbar;

    //弹出菜单
    private PopupWindow popupWindow;
    private PopupWindow popupCover;
    private ViewGroup customView;
    private ViewGroup coverView;
    private LayoutInflater layoutInflater;
    private RelativeLayout main;
    private WindowManager wm;
    private DisplayMetrics metrics;
    private TextView setting_text;
    private ImageView setting_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_main);
        initPrefs();
        btn = findViewById(R.id.fab);
        lv = findViewById(R.id.lv);
        mToolbar = findViewById(R.id.myToolbar);
        adapter = new NoteAdapter(getApplicationContext(), noteList);
        refreshListView();
        lv.setAdapter(adapter);

        setActionBar(mToolbar);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true); //设置toolbar取代actionbar

        initPopUpView();

        mToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUpView();
            }
        });
        lv.setOnItemClickListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditMainActivity.this, EditActivity.class);
                intent.putExtra("mode", 4);//新建笔记mode为4
                startActivityForResult(intent, 0);
            }
        });
    }

    public void initPrefs(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!sharedPreferences.contains("nightMode")) {
            editor.putBoolean("nightMode", false);
            editor.commit();
        }
    }
    public void showPopUpView(){
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        popupCover = new PopupWindow(coverView, width, height, false);
        popupWindow = new PopupWindow(customView, (int) (width * 0.7), height, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));


        //在主界面加载成功之后 显示弹出
        findViewById(R.id.main_layout).post(new Runnable() {
            @Override
            public void run() {
                popupCover.showAtLocation(main, Gravity.NO_GRAVITY, 0, 0);
                popupWindow.showAtLocation(main, Gravity.NO_GRAVITY, 0, 0);

                setting_image = customView.findViewById(R.id.setting_settings_image);
                setting_text = customView.findViewById(R.id.setting_settings_text);

                setting_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(EditMainActivity.this, SettingsActivity.class));
                    }
                });

                setting_text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(EditMainActivity.this, SettingsActivity.class));
                    }
                });

                coverView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        popupCover.dismiss();
                        Log.d(TAG, "onDismiss: test");
                    }
                });
            }

        });

    }

    public void initPopUpView(){
        layoutInflater = (LayoutInflater) EditMainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        customView = (ViewGroup) layoutInflater.inflate(R.layout.setting_layout, null);
        coverView = (ViewGroup) layoutInflater.inflate(R.layout.setting_cover, null);
        main = findViewById(R.id.main_layout);
        wm = getWindowManager();
        metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
    }
    private void refreshListView() {
        CRUD op = new CRUD(context);
        op.open();
        // set adapter
        if (noteList.size() > 0) noteList.clear();
        noteList.addAll(op.getAllNotes());
        op.close();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        int returnMode;
        long note_Id;
        returnMode = data.getExtras().getInt("mode", -1);
        note_Id = data.getExtras().getLong("id", 0);


        if (returnMode == 1) {  //update current note

            String content = data.getExtras().getString("content");
            String time = data.getExtras().getString("time");
            int tag = data.getExtras().getInt("tag", 1);

            Note newNote = new Note(content, time, tag);
            newNote.setId(note_Id);
            CRUD op = new CRUD(context);
            op.open();
            op.updateNote(newNote);
            op.close();
        } else if (returnMode == 0) {  // create new note
            String content = data.getExtras().getString("content");
            String time = data.getExtras().getString("time");
            int tag = data.getExtras().getInt("tag", 1);

            Note newNote = new Note(content, time, tag);
            CRUD op = new CRUD(context);
            op.open();
            op.addNote(newNote);
            op.close();
        } else if (returnMode == 2) { // delete
            Note curNote = new Note();
            curNote.setId(note_Id);
            CRUD op = new CRUD(context);
            op.open();
            op.removeNote(curNote);
            op.close();
        }
        else{

        }
        refreshListView();
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

//        //search setting
//        MenuItem mSearch = menu.findItem(R.id.action_search);
//        SearchView mSearchView = (SearchView) mSearch.getActionView();

//        mSearchView.setQueryHint("Search");
//        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_clear:
                new AlertDialog.Builder(EditMainActivity.this)
                        .setMessage("删除全部吗？")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbHelper = new NoteDatabase(context);
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                db.delete("notes", null, null);
                                db.execSQL("update sqlite_sequence set seq=0 where name='notes'");
                                refreshListView();
                            }
                        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.lv:
                Note curNote = (Note) parent.getItemAtPosition(position);
                Intent intent = new Intent(EditMainActivity.this, EditActivity.class);
                intent.putExtra("content", curNote.getContent());
                intent.putExtra("id", curNote.getId());
                intent.putExtra("time", curNote.getTime());
                intent.putExtra("mode", 3);     //修改笔记mode值为3 MODE of 'click to edit'
                intent.putExtra("tag", curNote.getTag());
                startActivityForResult(intent, 1);      //collect data from edit
                break;
        }
    }
}