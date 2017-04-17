package io.devcrew.mvvmdatabinding.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.devcrew.mvvmdatabinding.R;
import io.devcrew.mvvmdatabinding.databinding.FragmentTodoDetailBinding;
import io.devcrew.mvvmdatabinding.model.Todo;


public class TodoDetailFragment extends Fragment {

    private Todo mTodo;

    private OnFragmentInteractionListener mListener;

    public TodoDetailFragment() {
        // Required empty public constructor
    }


    public static TodoDetailFragment newInstance(Todo todo) {
        TodoDetailFragment fragment = new TodoDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(Todo.TODO, todo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTodo = getArguments().getParcelable(Todo.TODO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTodoDetailBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_todo_detail, container, false);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        binding.setMTodo(mTodo);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
