package jesus.de.andrade.elisa.galeriapublica;

import android.content.Context;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GalleryRepository {

    Context context;

    public GalleryRepository(Context context){
        this.context = context;
    }

    public List<ImageData> loadImageData(Integer limit, Integer offSet) throws FileNotFoundException {

        List<ImageData> imageDataList = new ArrayList<>();
        int w = (int)context.getResources().getDimension(R.dimen.im_width);
        int h = (int)context.getResources().getDimension(R.dimen.im_height);


        //Falta o return
        //im_width
    }


}
