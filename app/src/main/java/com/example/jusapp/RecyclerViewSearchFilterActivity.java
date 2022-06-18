package com.example.jusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewSearchFilterActivity extends AppCompatActivity implements UserAdapterForRecyclerView.UserClickListener {

    RecyclerView rvUsers;
    UserAdapterForRecyclerView userAdapter;
    List<UsersForRecyclerView> usersForRecyclerViewList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_searchfilter);

        rvUsers = findViewById(R.id.rvUsers);
        setData();
        prepareRecyclerView();


    }

    public void setData(){

        usersForRecyclerViewList.add(new UsersForRecyclerView("Abigail", "Watson", "abigail.watson@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Bethany", "Luwey", "bethany.luwey@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Cecilia", "Martin", "cecilia.martin@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Delia", "Salami", "delia.salami@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Fifi", "Lenorman", "fif.lenorman@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Andrea", "Rivileti", "andrea.rivileti@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Ahmed", "Awira", "ahmed.awira@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Remus", "Popescu", "remus.popescu@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Relu", "Oncescu", "relu.oncescu@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Bogdan", "Dragomir", "bogdan.dragomir@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Lidia", "Bahtilanovichy", "lidia.bahtilanovichy@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("George", "Williams", "george.williams@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Mario", "Donatelli", "mario.donatelli@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Elena", "Udrea", "elena.udrea@android.ro"));
        usersForRecyclerViewList.add(new UsersForRecyclerView("Samuel", "Hakturpy", "samuel.hakturpy@android.ro"));

    }

    public void prepareRecyclerView(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvUsers.setLayoutManager(linearLayoutManager);
        preAdater();

    }


    public void preAdater(){

        userAdapter = new UserAdapterForRecyclerView(usersForRecyclerViewList, this, this::selectedUser);
        rvUsers.setAdapter(userAdapter);

    }

    @Override
    public void selectedUser(UsersForRecyclerView usersForRecyclerView) {

//        Toast.makeText(this, "Selected user is" +" "+ usersForRecyclerView.getFirstname() +" "+ usersForRecyclerView.getLastname(), Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, SelectedUserActivity.class).putExtra("data", usersForRecyclerView));


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.searchView){

            return true;

        }

        return super.onOptionsItemSelected(item);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_filter_4_recycler_view, menu);

        MenuItem menuItem = menu.findItem(R.id.searchView);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {

                String searchStr = newText;

                userAdapter.getFilter().filter(newText);

                return false;

            }
        });

        return super.onCreateOptionsMenu(menu);

    }
}