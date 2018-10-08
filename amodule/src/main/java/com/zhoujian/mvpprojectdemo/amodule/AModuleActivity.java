package com.zhoujian.mvpprojectdemo.amodule;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.githang.statusbar.StatusBarCompat;

@Route(path = "/amodule/activity/AModuleActivity")
public class AModuleActivity extends AppCompatActivity {

    private Postcard build;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amodule);
        StatusBarCompat.setStatusBarColor(this, Color.parseColor("#FF4081"));

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                build = ARouter.getInstance().build("/bmodule/activity/BModuleActivity");
                build.withString("name", "周建");
                build.navigation();
            }
        });
    }
}
