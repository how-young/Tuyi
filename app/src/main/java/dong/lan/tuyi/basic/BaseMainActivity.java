/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dong.lan.tuyi.basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.easemob.easeui.controller.EaseUI;
import com.umeng.analytics.MobclickAgent;


public class BaseMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        if(!this.isTaskRoot()) {
            Intent intent = this.getIntent();
            String action = intent.getAction();
            if(intent.hasCategory("android.intent.category.LAUNCHER") && action.equals("android.intent.action.MAIN")) {
                this.finish();
                return;
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        EaseUI.getInstance().getNotifier().reset();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    /**
     * 返回
     * 
     * @param view
     */
    public void back(View view) {
        finish();
    }
    public void Show(String s)
    {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
    public void print(String s)
    {
        System.out.println(s);
    }
}
