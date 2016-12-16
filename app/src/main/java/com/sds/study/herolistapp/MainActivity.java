package com.sds.study.herolistapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] arr_name = {"batman", "captin", "flashman", "green",
            "ironman", "punisher", "robin", "spiderman", "superman", "wonder"};

    String[] arr_phone = {
            "010-1234-7770",
            "010-1234-7771",
            "010-1234-7772",
            "010-1234-7773",
            "010-1234-7774",
            "010-1234-7775",
            "010-1234-7776",
            "010-1234-7777",
            "010-1234-7778",
            "010-1234-7779"
    };
    int[] thumb = {
            R.drawable.batman,
            R.drawable.captain,
            R.drawable.flashman,
            R.drawable.green,
            R.drawable.ironman,
            R.drawable.punisher,
            R.drawable.robin,
            R.drawable.spiderman,
            R.drawable.superman,
            R.drawable.wonder
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_list);

        //layout을 얻어와서, 동적으로 아이템들을 채워넣자!!
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        for (int i = 0; i < 10; i++) {
            //데이터 생성
            Hero hero=new Hero();
            hero.setName(arr_name[i]);
            hero.setPhone(arr_phone[i]);
            hero.setImg(thumb[i]);

            //복합위젯 생성
            HeroItem item=new HeroItem(this,hero);
            layout.addView(item);

            item.setOnClickListener(this);
        }

    }

    public void onClick(View view) {
        TextView text_name = (TextView) view.findViewById(R.id.txt_name);

        //액티비티는 호출만 가능할뿐, 우리가 메모리에 직접 생성할 수 없다.
        //이 때, 개발자는 시스템에 원하는 내용을 즉, 의도를 보여야 한다..
        // (시스템이 이해할 수 있는 형태로 표현해야 하는데 이 때 사용하는 객체가 바로 Intent (의도)

        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra("data",text_name.getText());
        this.startActivity(intent);
        Toast.makeText(this, text_name.getText(), Toast.LENGTH_SHORT);
    }
}
