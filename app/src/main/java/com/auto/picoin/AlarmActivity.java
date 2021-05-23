package com.auto.picoin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmActivity extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "수업이끝났습니다. 퇴실버튼눌러주세요", Toast.LENGTH_SHORT).show();    // AVD 확인용
        Log.e("Alarm","알람입니다.");    // 로그 확인용
        Intent intent1= new Intent(context, AlaramActivity2.class);
//        브로드캐스트 리시버에서는 setflag를 해야 intent사용가능
        intent1.setFlags(intent1.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);

    }

}









//public class AlarmActivity extends AppCompatActivity {
//
//    private Intent intent;
//    private Intent intent1;
//    private final String packageName = "kr.go.hrd.app";
//    private final String packageNames = "com.instagram.android";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_alarm);
//
//        intent1 = this.getPackageManager().getLaunchIntentForPackage(packageName);
//    }
//
//    public void clickbtninstar(View view) {
//        AlarmActivity.this.startActivity(intent1);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        finish();
//    }
//}