package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        UUID crimeId = (UUID) intent.getSerializableExtra(EXTRA_CRIME_ID);
        int crimePosition = intent.getIntExtra(EXTRA_CRIME_POSITION, 0);
        return CrimeFragment.newInstance(crimeId, crimePosition);
    }

    private static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent.crime_id";
    private static final String EXTRA_CRIME_POSITION = "com.bignerdranch.android.criminalintent.crime_position";


    public static Intent newIntent(Context packageContext, UUID crimeId, int crimePosition) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        intent.putExtra(EXTRA_CRIME_POSITION, crimePosition);
        return intent;
    }
}
