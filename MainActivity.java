package com.example.youtubelogindatasave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.youtubelogindatasave.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String firstname, lastname,  age, username;
    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstname = binding.firstname.getText().toString();
                lastname = binding.lastname.getText().toString();
                age = binding.age.getText().toString();
                username = binding.username.getText().toString();

                if (!firstname.isEmpty() && !lastname.isEmpty() && !age.isEmpty() && !username.isEmpty()){
                    Users users = new Users(firstname,lastname,age,username);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");
                    reference.child(username).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.firstname.setText("");
                            binding.lastname.setText("");
                            binding.age.setText("");
                            binding.username.setText("");
                            Toast.makeText(MainActivity.this,"sucessfully updated",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}