package com.example.jusapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserAdapterForRecyclerView extends RecyclerView.Adapter<UserAdapterForRecyclerView.UserAdapterVh> implements Filterable {


    public List<UsersForRecyclerView> usersForRecyclerViewList = new ArrayList<>();

    public List<UsersForRecyclerView> getUsersForRecyclerViewListFilter = new ArrayList<>();

    public Context context;

    public UserClickListener userClickListener;



    public UserAdapterForRecyclerView(List<UsersForRecyclerView> usersForRecyclerViews, Context context,  UserClickListener userClickListener){

        this.usersForRecyclerViewList = usersForRecyclerViews;
        this.getUsersForRecyclerViewListFilter = usersForRecyclerViews;
        this.context = context;
        this.userClickListener = userClickListener;

    }



    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {


            @Override
            protected FilterResults performFiltering(CharSequence constraint) {


                FilterResults filterResults = new FilterResults();

//Checking if the filtering started

                //Filter didn't start
                if(constraint == null || constraint.length() == 0){

                    filterResults.values = getUsersForRecyclerViewListFilter;
                    filterResults.count = getUsersForRecyclerViewListFilter.size();

                }
                    //Filter started
                    else{

                            String searchStr = constraint.toString().toLowerCase();
                            List<UsersForRecyclerView> usersForRecyclerViews = new ArrayList<>();

                            for(UsersForRecyclerView usersForRecyclerView : getUsersForRecyclerViewListFilter){

                                if(usersForRecyclerView.getFirstname().toLowerCase().contains(searchStr) || usersForRecyclerView.getLastname().toLowerCase().contains(searchStr) || usersForRecyclerView.getEmail().toLowerCase().contains(searchStr)){

                                    usersForRecyclerViews.add(usersForRecyclerView);


                                }


                            }


                            filterResults.values = usersForRecyclerViews;
                            filterResults.count = usersForRecyclerViews.size();

                }

                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraints, FilterResults results) {

                usersForRecyclerViewList = (List<UsersForRecyclerView>) results.values;
                notifyDataSetChanged();

            }
        };

        return filter;
    }

    public interface UserClickListener{

        void selectedUser(UsersForRecyclerView usersForRecyclerView);





    }


    @NonNull
    @Override
    public UserAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_users, parent, false);
        return new UserAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVh holder, int position) {

        UsersForRecyclerView  usersForRecyclerView= usersForRecyclerViewList.get(position);
        String firstName = usersForRecyclerView.getFirstname();
        String lastName = usersForRecyclerView.getLastname();
        String email = usersForRecyclerView.getEmail();
        String userName = firstName +" " + lastName;
        String abreviation = firstName.charAt(0) +""+ lastName.charAt(0);

        holder.userEmail.setText(email);
        holder.userName.setText(userName);
        holder.userAbreviation.setText(abreviation);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userClickListener.selectedUser(usersForRecyclerView);

            }
        });

    }

    @Override
    public int getItemCount() {
        return usersForRecyclerViewList.size();
    }

    public static class UserAdapterVh extends RecyclerView.ViewHolder {


        private TextView userAbreviation;
        private TextView userName;
        private TextView userEmail;

        public UserAdapterVh(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.tvuserName);
            userAbreviation = itemView.findViewById(R.id.tvuserAbreviation);
            userEmail = itemView.findViewById(R.id.tvuserEmail);


        }
    }


}
