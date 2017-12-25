package com.anxell.e5ar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.anxell.e5ar.custom.FontTextView;
import com.anxell.e5ar.transport.APPConfig;
import com.anxell.e5ar.transport.bpActivity;
import com.anxell.e5ar.util.Util;

public class ProximityReadRangeActivity1 extends bpActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private FontTextView mDeviceDistanceTV;
    private FontTextView mDeviceCurrDistanceTV;
    private SeekBar expectLEVELBar;
    private String deviceBDAddr;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_read_range_1);

        findViews();
        setListeners();
        Intent intent = getIntent();
        int currLevel = intent.getIntExtra(APPConfig.RSSI_LEVEL_Tag, 0);
        Util.debugMessage("Proximity","curr rssi="+currLevel,true);
        deviceBDAddr = intent.getStringExtra(APPConfig.deviceBddrTag);
        mDeviceCurrDistanceTV.setText(""+currLevel);
        int expectLevel = loadDeviceRSSILevel(deviceBDAddr);
        mDeviceDistanceTV.setText(""+expectLevel);
        expectLEVELBar.setProgress(expectLevel);
        expectLEVELBar.setMax(20);
    }

    private void findViews() {
        mDeviceDistanceTV = (FontTextView) findViewById(R.id.deviceDistanceValue);
        mDeviceCurrDistanceTV = (FontTextView) findViewById(R.id.deviceDistance);
        expectLEVELBar = (SeekBar)findViewById(R.id.proximity_expect_seekBar);
    }

    private void setListeners() {
        findViewById(R.id.skip).setOnClickListener(this);
        ((SeekBar)findViewById(R.id.seekBar)).setOnSeekBarChangeListener(this);
        findViewById(R.id.done).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.skip:
                openHomePage();
                break;

            case R.id.done:
                openHomePage();
                break;
        }
    }

    private void openHomePage() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        overridePendingTransitionRightToLeft();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransitionLeftToRight();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        mDeviceDistanceTV.setText(progress + "");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
