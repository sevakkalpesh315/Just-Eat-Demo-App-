
package myapp.tae.ac.uk.justeattest.Model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Logo implements Parcelable
{
    @Expose
    private String StandardResolutionURL;
    public final static Creator<Logo> CREATOR = new Creator<Logo>() {


        public Logo createFromParcel(Parcel in) {
            Logo instance = new Logo();
            instance.StandardResolutionURL = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Logo[] newArray(int size) {
            return (new Logo[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The StandardResolutionURL
     */
    public String getStandardResolutionURL() {
        return StandardResolutionURL;
    }

    /**
     * 
     * @param StandardResolutionURL
     *     The StandardResolutionURL
     */
    public void setStandardResolutionURL(String StandardResolutionURL) {
        this.StandardResolutionURL = StandardResolutionURL;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(StandardResolutionURL);
    }

    public int describeContents() {
        return  0;
    }

}
