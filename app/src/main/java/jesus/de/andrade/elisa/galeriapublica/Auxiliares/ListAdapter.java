package jesus.de.andrade.elisa.galeriapublica.Auxiliares;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;

import kotlinx.coroutines.CoroutineDispatcher;

public class ListAdapter extends PagingDataAdapter<ImageData,MyViewHolder> {


    public ListAdapter(@NonNull DiffUtil.ItemCallback<ImageData> diffCallback, @NonNull CoroutineDispatcher mainDispatcher) {
        super(diffCallback, mainDispatcher);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }
}
