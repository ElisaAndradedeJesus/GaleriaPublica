package jesus.de.andrade.elisa.galeriapublica;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;

public class MainViewModel extends AndroidViewModel {

    int navigationOpSelected = R.id.gridViewOp;
    LiveData<PagingData<ImageData>> pageLv;

    public MainViewModel(@NonNull Application application){
        super(application);
        GalleryRepository galleryRepository = new GalleryRepository(application);
        GalleryPagingSource galleryPagingSource = new GalleryPagingSource(galleryRepository);
        Pager<Integer, ImageData> pager = new Pager(new PagingConfig(10), () -> galleryPagingSource);
        //linha 11
    }

    public int getNavigationOpSelected() {
        return navigationOpSelected;
    }

    public void setNavigationOpSelected(int navigationOpSelected) {
        this.navigationOpSelected = navigationOpSelected;
    }
}
