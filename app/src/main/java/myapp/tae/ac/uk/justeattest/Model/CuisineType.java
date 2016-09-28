
package myapp.tae.ac.uk.justeattest.Model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CuisineType implements Parcelable
{
    @Expose
    private Integer Id;
    @Expose
    private String Name;
    @Expose
    private String SeoName;
    public final static Creator<CuisineType> CREATOR = new Creator<CuisineType>() {


        public CuisineType createFromParcel(Parcel in) {
            CuisineType instance = new CuisineType();
            instance.Id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.Name = ((String) in.readValue((String.class.getClassLoader())));
            instance.SeoName = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public CuisineType[] newArray(int size) {
            return (new CuisineType[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The Id
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The Name
     */
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @return
     *     The SeoName
     */
    public String getSeoName() {
        return SeoName;
    }

    /**
     * 
     * @param SeoName
     *     The SeoName
     */
    public void setSeoName(String SeoName) {
        this.SeoName = SeoName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(Id);
        dest.writeValue(Name);
        dest.writeValue(SeoName);
    }

    public int describeContents() {
        return  0;
    }

}
