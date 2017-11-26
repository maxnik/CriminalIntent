package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by maxnik on 11/26/17.
 */

public class PhotoFragment extends DialogFragment {

    private static final String ARG_PHOTO = "photo";

    private ImageView mPhotoView;

    public static PhotoFragment newInstance(String path) {
        Bundle args  = new Bundle();
        args.putString(ARG_PHOTO, path);

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_photo, null);

        String path = getArguments().getString(ARG_PHOTO);
        mPhotoView = v.findViewById(R.id.crime_photo);
        Bitmap bitmap = PictureUtils.getScaledBitmap(path, getActivity());
        mPhotoView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.photo_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
