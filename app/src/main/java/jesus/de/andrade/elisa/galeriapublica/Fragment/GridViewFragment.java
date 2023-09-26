package jesus.de.andrade.elisa.galeriapublica.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.Nullable;

import jesus.de.andrade.elisa.galeriapublica.Auxiliares.GridAdapter;
import jesus.de.andrade.elisa.galeriapublica.Auxiliares.ImageData;
import jesus.de.andrade.elisa.galeriapublica.Auxiliares.ImageDataComparator;
import jesus.de.andrade.elisa.galeriapublica.Auxiliares.MainViewModel;
import jesus.de.andrade.elisa.galeriapublica.R;


public class GridViewFragment extends Fragment {

    private MainViewModel mViewModel;
    private View view;


    public GridViewFragment() {
        // Required empty public constructor
    }

    public static GridViewFragment newInstance() {
        return new GridViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        mViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        GridAdapter gridAdapter = new GridAdapter(new ImageDataComparator());
        LiveData<PagingData<ImageData>> liveData = mViewModel.getPageLv();
        liveData.observe(getViewLifecycleOwner(), new Observer<PagingData<ImageData>>() {
            @Override
            public void onChanged(PagingData<ImageData> objectPagingData) {
                gridAdapter.submitData(getViewLifecycleOwner().getLifecycle(),objectPagingData);
            }
        });
        RecyclerView rvGallery = (RecyclerView) view.findViewById(R.id.rvGrid);
        rvGallery.setAdapter(gridAdapter);
        rvGallery.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }
    private int NumberOfColumns(){
        return 0;
    }
}