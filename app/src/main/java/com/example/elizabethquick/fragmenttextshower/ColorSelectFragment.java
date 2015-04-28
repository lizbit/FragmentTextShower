package com.example.elizabethquick.fragmenttextshower;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ColorSelectFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ColorSelectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorSelectFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    SeekBar alphaSeek;
    SeekBar redSeek;
    SeekBar greenSeek;
    SeekBar blueSeek;
    int color;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ColorSelectFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ColorSelectFragment newInstance(String param1, String param2) {
        ColorSelectFragment fragment = new ColorSelectFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ColorSelectFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //This is where we put the initial stuff.
        View view = inflater.inflate(R.layout.fragment_color_select, container, false);

        alphaSeek = (SeekBar) view.findViewById(R.id.alpha);
        redSeek = (SeekBar) view.findViewById(R.id.red);
        greenSeek = (SeekBar) view.findViewById(R.id.green);
        blueSeek = (SeekBar) view.findViewById(R.id.blue);

        alphaSeek.setOnSeekBarChangeListener(changeColor);
        redSeek.setOnSeekBarChangeListener(changeColor);
        greenSeek.setOnSeekBarChangeListener(changeColor);
        blueSeek.setOnSeekBarChangeListener(changeColor);

        return view;
    }


    SeekBar.OnSeekBarChangeListener changeColor = new SeekBar.OnSeekBarChangeListener(){

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            color = 0x1000000*alphaSeek.getProgress() + 0x10000*redSeek.getProgress() + 0x100*greenSeek.getProgress() + blueSeek.getProgress();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public int getColor(){
        return this.color;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
