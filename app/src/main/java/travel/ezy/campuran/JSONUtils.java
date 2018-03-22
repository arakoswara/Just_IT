package travel.ezy.campuran;

import com.google.gson.Gson;

public class JSONUtils {
    public static ApotikResponse apotikResponse(String data)
    {
        if (data.contains("code"))
        {
            return new Gson().fromJson(data, ApotikResponse.class);
        }
        return new ApotikResponse();
    }
}
