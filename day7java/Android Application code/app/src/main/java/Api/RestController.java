package Api;

import Data.DataModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestController {

    @GET("employee")
    Call<ResponseBody> getData();

    @POST("addemployee")
    Call<ResponseBody> addData(@Body DataModel dataModel);


}
