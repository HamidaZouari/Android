package com.example.rv;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    DatabaseHelper db;
        private final Context mContext;
        private final ArrayList<Contact> mUserList;
    EditText itemName,itemNumber;

        public UserAdapter(Context context, ArrayList<Contact> userList) {
            mContext = context;
            mUserList = userList;
            db=new DatabaseHelper(context);
        }

        public class UserViewHolder extends RecyclerView.ViewHolder {
            int id;
            private final TextView mName;
            private final ImageView edit,delete;

            private final TextView mNum;
          //  private final ImageView mMenus;

            public UserViewHolder(View v) {
                super(v);
                mName = v.findViewById(R.id.nom);
                mNum = v.findViewById(R.id.numero);
                delete=v.findViewById(R.id.deleteImg);
                edit=v.findViewById(R.id.editImg);
            }
            public void setId(int id) {
                this.id = id;
            }
        }

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
            return new UserViewHolder(v);
        }

        @Override
        public void onBindViewHolder(UserViewHolder holder, int position) {
            int i =position;

            holder.mName.setText(mUserList.get(position).getContactName());
            holder.mNum.setText(mUserList.get(position).getContactNumber());
            holder.setId(mUserList.get(position).getId());
            holder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                    LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View customLayout = inflater.inflate(R.layout.form2, null);

                    alert.setTitle("Update contact "+holder.mName.getText());
                    alert.setView(customLayout);
                    itemName = customLayout.findViewById(R.id.userName);
                    itemNumber = customLayout.findViewById(R.id.userNumber);
                    itemName.setText(holder.mName.getText());
                    itemNumber.setText(holder.mNum.getText());
                    alert.setPositiveButton("Update", (dialog1, whichButton) -> {
                        if(!itemName.getText().toString().equals("")&&!itemNumber.getText().toString()
                                .equals("")) {
                            holder.mName.setText(itemName.getText().toString());
                            holder.mNum.setText(itemNumber.getText().toString());
                            mUserList.get(i).setContactName(itemName.getText().toString());
                            mUserList.get(i).setContactNumber(itemNumber.getText().toString());
                            db.updateContact(mUserList.get(i));

                        } else {
                            Toast.makeText(mContext,"Update failed",Toast.LENGTH_LONG).show();

                        }



                    });
                    alert.setNegativeButton("cancel",null);
                    alert.show();
                }
            }
            );
            holder.delete.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    int toDelete=i;
                    AlertDialog.Builder alert=new AlertDialog.Builder(mContext);
                    alert.setTitle("Delete contact ");
                    alert.setMessage("Are you sure you want to delete "+mUserList.get(toDelete).getContactName()+"?");
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.deleteContact(mUserList.get(toDelete));
                            mUserList.remove(mUserList.get(toDelete));

                            notifyItemRemoved(i);

                            notifyDataSetChanged();


                        }
                    });
                    alert.setNegativeButton("No",null);
                    alert.show();
                }
            });

        }

        @Override
        public int getItemCount() {

            return mUserList.size();
        }


    }
