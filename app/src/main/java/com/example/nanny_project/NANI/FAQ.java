package com.example.nanny_project.NANI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.R;

public class FAQ extends AppCompatActivity implements View.OnClickListener {
    TextView que1,ans1,que2,ans2,que3,ans3,tv_title;
    ImageView iv_back,iv_menu,iv_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        findIds();
    }



    private void findIds() {
        iv_back=findViewById(R.id.iv_back);
        iv_back.setVisibility(View.VISIBLE);
        iv_back.setOnClickListener(this);

        iv_menu=findViewById(R.id.iv_menu);
        iv_menu.setVisibility(View.GONE);

        iv_notification=findViewById(R.id.iv_notification);
        iv_notification.setVisibility(View.GONE);

        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("FAQs");

        que1=findViewById(R.id.que1);
        que1.setText("Should I update? How can I Update?");
        ans1=findViewById(R.id.ans1);
        ans1.setText("The Nani team is always trying to improve their user experience. We therefore are always coming up with innovative ways to keep you happy." +
                "For this to happen, we request that you please head to the App store and ensure that you have the latest version of the Nani App." +
                "If not, update your app ASAP. We can't afford for you to miss out");
        que2=findViewById(R.id.que2);
        que2.setText("What is difference between Collection/Delivery either Today or Tomorrow");
        ans2=findViewById(R.id.ans2);
        ans2.setText("Today:Items available Today are those which are ready and available immediately." +
                "A Driver will be dispatched to collect the item as soon as order placed i.e. Same day collection and delivery." +
                "Tomorrow: Items available Tomorrow are those items which require a little extra time to prepare once an order is received." +
                "A Driver will be dispatched to collect and deliver that item a day after the order was placed i.e. Next day collection and delivery.");
        que3=findViewById(R.id.que3);
        que3.setText("Can I trust as Nani?");
        ans3=findViewById(R.id.ans3);
        ans3.setText("To be Nani on the NANI App, a Nani must provide some references and will be vetted stringetly before given access to post items publicly on the" +
                "platform.");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                onBackPressed();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
