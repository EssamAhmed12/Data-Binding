package com.example.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.databinding.databinding.ActivityMainBinding;
import com.example.databinding.models.Product;
import com.example.databinding.util.Products;

public class MainActivity extends AppCompatActivity implements IMainActiviy {


    //data binding
    ActivityMainBinding mBinding;

    //vars
    private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Products products = new Products();
        mProduct = products.PRODUCTS[0];

        mBinding.setProduct(mProduct);
        mBinding.setQuantity(1);
        mBinding.setIMainActivity((IMainActiviy)this);
        mBinding.setTestUrl("https://i.redd.it/g5acbfi5hkm01.jpg");
    }

    @Override
    public void inflateQuantityDialog() {
        ChooseQuantityDialog dialog = new ChooseQuantityDialog();
        dialog.show(getSupportFragmentManager(), getString(R.string.dialog_choose_quantity));
    }

    @Override
    public void setQuantity(int quantity) {
        mBinding.setQuantity(quantity);
    }
}

