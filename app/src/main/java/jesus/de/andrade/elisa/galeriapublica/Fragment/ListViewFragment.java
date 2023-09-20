package jesus.de.andrade.elisa.galeriapublica.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jesus.de.andrade.elisa.galeriapublica.Auxiliares.ImageData;
import jesus.de.andrade.elisa.galeriapublica.Auxiliares.ImageDataComparator;
import jesus.de.andrade.elisa.galeriapublica.Auxiliares.ListAdapter;
import jesus.de.andrade.elisa.galeriapublica.Auxiliares.MainViewModel;
import jesus.de.andrade.elisa.galeriapublica.R;


public class ListViewFragment extends Fragment {

    private MainViewModel mViewModel;
    private View view;

    public ListViewFragment() {
        // Required empty public constructor
    }

    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        mViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        ListAdapter listAdapter = new ListAdapter(new ImageDataComparator());
        LiveData<PagingData<ImageData>> liveData = mViewModel.getPageLv();
        liveData.observe(getViewLifecycleOwner(),new Observer<PagingData<ImageData>>() {
            @Override
            public void onChanged(PagingData<ImageData> objectPagingData) {
                listAdapter.submitData(getViewLifecycleOwner().getLifecycle(), objectPagingData);
            }
        });
        RecyclerView tvGallery = (RecyclerView) view.findViewById(R.id.rvList);
        tvGallery.setAdapter(listAdapter);
        tvGallery.setLayoutManager(new LinearLayoutManager(getContext()));
    }




}