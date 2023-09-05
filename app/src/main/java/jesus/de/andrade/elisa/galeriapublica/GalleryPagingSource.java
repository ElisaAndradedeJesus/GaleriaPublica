package jesus.de.andrade.elisa.galeriapublica;


import android.widget.Gallery;

import androidx.annotation.NonNull;
import androidx.paging.PagingState;

public class GalleryPagingSource extends ListenableFuturePagingSource <Integer, ImageData>{
    GalleryRepository galleryRepository;

    Integer initialLoadSize = 0;

    public GalleryPagingSource(GalleryRepository galleryRepository){
        this.galleryRepository = galleryRepository;
    }

    @NonNull
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer,ImageData> pagingState){
        return null;
    }
}
