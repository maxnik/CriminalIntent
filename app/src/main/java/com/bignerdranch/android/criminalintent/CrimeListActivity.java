package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by maxnik on 11/14/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
