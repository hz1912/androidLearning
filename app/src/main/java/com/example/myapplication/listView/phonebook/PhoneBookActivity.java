package com.example.myapplication.listView.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhoneBookActivity extends AppCompatActivity {

    private ListView phoneList;

    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book);
        phoneList = findViewById(R.id.phone_list);
        initData();
        phoneList.setAdapter(new PhoneListAdapter(this,userList));
    }



    private void initData() {
        userList = new ArrayList<>();
        String[] namesArry = getResources().getStringArray(R.array.phone_name);
        for (int i = 0; i < namesArry.length; i++) {
            User user = new User();
            user.setUsername(namesArry[i]);
            String convert = ChineseToPinyinHelper.getInstance().getPinyin(namesArry[i]).toUpperCase();
            user.setPinyin(convert);
            String substring = convert.substring(0, 1);
            user.setFirstLetter(substring);
            if (substring.matches("[A-Z]")) {
                user.setFirstLetter(substring);
            } else {
                user.setFirstLetter("#");
            }
            userList.add(user);
        }
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User lhs, User rhs) {
                if (lhs.getFirstLetter().contains("#")) {
                    return 1;
                } else if (rhs.getFirstLetter().contains("#")) {
                    return -1;
                } else {
                    return lhs.getFirstLetter().compareTo(rhs.getFirstLetter());
                }
            }
        });
    }


}
