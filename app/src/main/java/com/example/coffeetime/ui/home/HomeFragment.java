package com.example.coffeetime.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeetime.ListAdapter;
import com.example.coffeetime.R;
import com.example.coffeetime.databinding.FragmentHomeBinding;
import com.example.coffeetime.model.Product;
import com.google.firebase.FirebaseApp  ;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    View view;

    public List<Product> listProduct = new ArrayList<Product>();
    ArrayAdapter<Product> arrayAdapterProduct;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        initFirebase();
        listProduct();

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initFirebase(){
        FirebaseApp.initializeApp(getActivity());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void listProduct(){
        databaseReference.child("Product").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                listProduct.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Product product = dataSnapshot.getValue(Product.class);
                    listProduct.add(product);
                }
                ListAdapter listAdapter = new ListAdapter(listProduct,getActivity());
                RecyclerView recyclerView = view.findViewById(R.id.listProduct);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(listAdapter);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
                Toast.makeText(getActivity(),"Aviso De Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

}