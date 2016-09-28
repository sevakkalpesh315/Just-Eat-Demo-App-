
package myapp.tae.ac.uk.justeattest.Model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class JustEat implements Parcelable
{
    @Expose
    private List<Restaurant> Restaurants = new ArrayList<Restaurant>();
    @Expose
    private String ShortResultText;
    @Expose
    private String Area;
    @Expose
    private Object Errors;
    @Expose
    private Boolean HasErrors;
    public final static Creator<JustEat> CREATOR = new Creator<JustEat>() {


        public JustEat createFromParcel(Parcel in) {
            JustEat instance = new JustEat();
            in.readList(instance.Restaurants, (myapp.tae.ac.uk.justeattest.Model.Restaurant.class.getClassLoader()));
            instance.ShortResultText = ((String) in.readValue((String.class.getClassLoader())));
            instance.Area = ((String) in.readValue((String.class.getClassLoader())));
            instance.Errors = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.HasErrors = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            return instance;
        }

        public JustEat[] newArray(int size) {
            return (new JustEat[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The Restaurants
     */
    public List<Restaurant> getRestaurants() {
        return Restaurants;
    }

    /**
     * 
     * @param Restaurants
     *     The Restaurants
     */
    public void setRestaurants(List<Restaurant> Restaurants) {
        this.Restaurants = Restaurants;
    }

    /**
     * 
     * @return
     *     The ShortResultText
     */
    public String getShortResultText() {
        return ShortResultText;
    }

    /**
     * 
     * @param ShortResultText
     *     The ShortResultText
     */
    public void setShortResultText(String ShortResultText) {
        this.ShortResultText = ShortResultText;
    }

    /**
     * 
     * @return
     *     The Area
     */
    public String getArea() {
        return Area;
    }

    /**
     * 
     * @param Area
     *     The Area
     */
    public void setArea(String Area) {
        this.Area = Area;
    }

    /**
     * 
     * @return
     *     The Errors
     */
    public Object getErrors() {
        return Errors;
    }

    /**
     * 
     * @param Errors
     *     The Errors
     */
    public void setErrors(Object Errors) {
        this.Errors = Errors;
    }

    /**
     * 
     * @return
     *     The HasErrors
     */
    public Boolean getHasErrors() {
        return HasErrors;
    }

    /**
     * 
     * @param HasErrors
     *     The HasErrors
     */
    public void setHasErrors(Boolean HasErrors) {
        this.HasErrors = HasErrors;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(Restaurants);
        dest.writeValue(ShortResultText);
        dest.writeValue(Area);
        dest.writeValue(Errors);
        dest.writeValue(HasErrors);
    }

    public int describeContents() {
        return  0;
    }

}
