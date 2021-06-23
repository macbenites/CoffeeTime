package com.example.coffeetime.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.coffeetime.R;
import com.example.coffeetime.databinding.FragmentHomeBinding;
import com.example.coffeetime.model.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public List<Product> listProduct = new ArrayList<Product>();
    ArrayAdapter<Product> arrayAdapterProduct;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String url = "https://static.india.com/wp-content/uploads/2018/09/42-4.jpg";
    ImageView imageView;


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageView = view.findViewById(R.id.imgProduct);
        Picasso.get()
                .load(url)
                .into(imageView);

        return inflater.inflate(R.layout.fragment_home, container, false);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}