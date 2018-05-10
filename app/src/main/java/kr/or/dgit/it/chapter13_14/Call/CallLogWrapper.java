package kr.or.dgit.it.chapter13_14.Call;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kr.or.dgit.it.chapter13_14.R;

public class CallLogWrapper {
    public ImageView personImageView;
    public TextView nameView;
    public TextView dateView;
    public ImageView dialerImageView;

    public CallLogWrapper(View root){
        personImageView = root.findViewById(R.id.mission_list_person);
        nameView= root.findViewById(R.id.mission_list_name);
        dateView = root.findViewById(R.id.mission_list_date);
        dialerImageView = root.findViewById(R.id.mission_list_dialer);
    }
}
