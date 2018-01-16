package list.chenmiaohui.com.textproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    Environment.getExternalStorageDirectory();
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
        File Root = Environment.getExternalStorageDirectory();
        MyAdapter adapter = new MyAdapter(this);
        List<File> lists = new ArrayList<>();
        File[] files = Root.listFiles();
        for (File f: files){
            lists.add(f);
        }
//        for (int i=1;i<=50;i++){
//            lists.add(new Text("我是第"+i+"个",R.mipmap.ic_launcher));
//        }
        adapter.setDataLists(lists);
        mListView.setAdapter(adapter);
    }
    //6.0手动添加权限。
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

}
