package jesus.de.andrade.elisa.galeriapublica.Auxiliares;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import jesus.de.andrade.elisa.galeriapublica.Auxiliares.GalleryPagingSource;
import jesus.de.andrade.elisa.galeriapublica.Auxiliares.GalleryRepository;
import jesus.de.andrade.elisa.galeriapublica.Auxiliares.ImageData;
import jesus.de.andrade.elisa.galeriapublica.R;
import kotlinx.coroutines.CoroutineScope;

public class MainViewModel extends AndroidViewModel {

    int navigationOpSelected = R.id.gridViewOp;
    LiveData<PagingData<ImageData>> pageLv;

    public MainViewModel(@NonNull Application application){
        super(application);
        GalleryRepository galleryRepository = new GalleryRepository(application);
        GalleryPagingSource galleryPagingSource = new GalleryPagingSource(galleryRepository);
        Pager<Integer, ImageData> pager = new Pager(new PagingConfig(10), () -> galleryPagingSource);
        //linha 11
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);

        pageLv = PagingData.cachedIn(PagingLiveData.getLiveData(pager), viewModelScope);
    }

    public LiveData<PagingData<ImageData>> getPageLv(){
        return pageLv;
    }

    public int getNavigationOpSelected() {
        return navigationOpSelected;
    }

    public void setNavigationOpSelected(int navigationOpSelected) {
        this.navigationOpSelected = navigationOpSelected;
    }
}
