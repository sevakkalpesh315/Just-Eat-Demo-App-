
package myapp.tae.ac.uk.justeattest.Model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class Restaurant implements Parcelable
{
    @Expose
    private List<Object> Badges = new ArrayList<Object>();
    @Expose
    private Double Score;
    @Expose
    private Double DriveDistance;
    @Expose
    private Boolean DriveInfoCalculated;
    @Expose
    private String NewnessDate;
    @Expose
    private Integer DeliveryMenuId;
    @Expose
    private String DeliveryOpeningTime;
    @Expose
    private Double DeliveryCost;
    @Expose
    private Double MinimumDeliveryValue;
    @Expose
    private Object DeliveryTime;
    @Expose
    private String OpeningTime;
    @Expose
    private String OpeningTimeIso;
    @Expose
    private Boolean SendsOnItsWayNotifications;
    @Expose
    private Double RatingAverage;
    @Expose
    private Double Latitude;
    @Expose
    private Double Longitude;
    @Expose
    private Integer Id;
    @Expose
    private String Name;
    @Expose
    private String Address;
    @Expose
    private String Postcode;
    @Expose
    private String City;
    @Expose
    private List<CuisineType> CuisineTypes = new ArrayList<CuisineType>();
    @Expose
    private String Url;
    @Expose
    private Boolean IsOpenNow;
    @Expose
    private Boolean IsSponsored;
    @Expose
    private Boolean IsNew;
    @Expose
    private Boolean IsTemporarilyOffline;
    @Expose
    private String ReasonWhyTemporarilyOffline;
    @Expose
    private String UniqueName;
    @Expose
    private Boolean IsCloseBy;
    @Expose
    private Boolean IsHalal;
    @Expose
    private Integer DefaultDisplayRank;
    @Expose
    private Boolean IsOpenNowForDelivery;
    @Expose
    private Boolean IsOpenNowForCollection;
    @Expose
    private Double RatingStars;
    @Expose
    private List<myapp.tae.ac.uk.justeattest.Model.Logo> Logo = new ArrayList<myapp.tae.ac.uk.justeattest.Model.Logo>();
    @Expose
    private List<Object> Deals = new ArrayList<Object>();
    @Expose
    private Integer NumberOfRatings;
    public final static Creator<Restaurant> CREATOR = new Creator<Restaurant>() {


        public Restaurant createFromParcel(Parcel in) {
            Restaurant instance = new Restaurant();
            in.readList(instance.Badges, (Object.class.getClassLoader()));
            instance.Score = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.DriveDistance = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.DriveInfoCalculated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.NewnessDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.DeliveryMenuId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.DeliveryOpeningTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.DeliveryCost = ((Double) in.readValue((Integer.class.getClassLoader())));
            instance.MinimumDeliveryValue = ((Double) in.readValue((Integer.class.getClassLoader())));
            instance.DeliveryTime = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.OpeningTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.OpeningTimeIso = ((String) in.readValue((String.class.getClassLoader())));
            instance.SendsOnItsWayNotifications = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.RatingAverage = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.Latitude = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.Longitude = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.Id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.Name = ((String) in.readValue((String.class.getClassLoader())));
            instance.Address = ((String) in.readValue((String.class.getClassLoader())));
            instance.Postcode = ((String) in.readValue((String.class.getClassLoader())));
            instance.City = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.CuisineTypes, (myapp.tae.ac.uk.justeattest.Model.CuisineType.class.getClassLoader()));
            instance.Url = ((String) in.readValue((String.class.getClassLoader())));
            instance.IsOpenNow = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.IsSponsored = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.IsNew = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.IsTemporarilyOffline = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.ReasonWhyTemporarilyOffline = ((String) in.readValue((String.class.getClassLoader())));
            instance.UniqueName = ((String) in.readValue((String.class.getClassLoader())));
            instance.IsCloseBy = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.IsHalal = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.DefaultDisplayRank = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.IsOpenNowForDelivery = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.IsOpenNowForCollection = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.RatingStars = ((Double) in.readValue((Double.class.getClassLoader())));
            in.readList(instance.Logo, (myapp.tae.ac.uk.justeattest.Model.Logo.class.getClassLoader()));
            in.readList(instance.Deals, (Object.class.getClassLoader()));
            instance.NumberOfRatings = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Restaurant[] newArray(int size) {
            return (new Restaurant[size]);
        }

    }
            ;

    /**
     * Model
     * @return
     *     The Badges
     */
    public List<Object> getBadges() {
        return Badges;
    }

    /**
     *
     * @param Badges
     *     The Badges
     */
    public void setBadges(List<Object> Badges) {
        this.Badges = Badges;
    }

    /**
     *
     * @return
     *     The Score
     */
    public Double getScore() {
        return Score;
    }

    /**
     *
     * @param Score
     *     The Score
     */
    public void setScore(Double Score) {
        this.Score = Score;
    }

    /**
     *
     * @return
     *     The DriveDistance
     */
    public Double getDriveDistance() {
        return DriveDistance;
    }

    /**
     *
     * @param DriveDistance
     *     The DriveDistance
     */
    public void setDriveDistance(Double DriveDistance) {
        this.DriveDistance = DriveDistance;
    }

    /**
     *
     * @return
     *     The DriveInfoCalculated
     */
    public Boolean getDriveInfoCalculated() {
        return DriveInfoCalculated;
    }

    /**
     *
     * @param DriveInfoCalculated
     *     The DriveInfoCalculated
     */
    public void setDriveInfoCalculated(Boolean DriveInfoCalculated) {
        this.DriveInfoCalculated = DriveInfoCalculated;
    }

    /**
     *
     * @return
     *     The NewnessDate
     */
    public String getNewnessDate() {
        return NewnessDate;
    }

    /**
     *
     * @param NewnessDate
     *     The NewnessDate
     */
    public void setNewnessDate(String NewnessDate) {
        this.NewnessDate = NewnessDate;
    }

    /**
     *
     * @return
     *     The DeliveryMenuId
     */
    public Integer getDeliveryMenuId() {
        return DeliveryMenuId;
    }

    /**
     *
     * @param DeliveryMenuId
     *     The DeliveryMenuId
     */
    public void setDeliveryMenuId(Integer DeliveryMenuId) {
        this.DeliveryMenuId = DeliveryMenuId;
    }

    /**
     *
     * @return
     *     The DeliveryOpeningTime
     */
    public String getDeliveryOpeningTime() {
        return DeliveryOpeningTime;
    }

    /**
     *
     * @param DeliveryOpeningTime
     *     The DeliveryOpeningTime
     */
    public void setDeliveryOpeningTime(String DeliveryOpeningTime) {
        this.DeliveryOpeningTime = DeliveryOpeningTime;
    }

    /**
     *
     * @return
     *     The DeliveryCost
     */
    public Double getDeliveryCost() {
        return DeliveryCost;
    }

    /**
     *
     * @param DeliveryCost
     *     The DeliveryCost
     */
    public void setDeliveryCost(Double DeliveryCost) {
        this.DeliveryCost = DeliveryCost;
    }

    /**
     *
     * @return
     *     The MinimumDeliveryValue
     */
    public Double getMinimumDeliveryValue() {
        return MinimumDeliveryValue;
    }

    /**
     *
     * @param MinimumDeliveryValue
     *     The MinimumDeliveryValue
     */
    public void setMinimumDeliveryValue(Double MinimumDeliveryValue) {
        this.MinimumDeliveryValue = MinimumDeliveryValue;
    }

    /**
     *
     * @return
     *     The DeliveryTime
     */
    public Object getDeliveryTime() {
        return DeliveryTime;
    }

    /**
     *
     * @param DeliveryTime
     *     The DeliveryTime
     */
    public void setDeliveryTime(Object DeliveryTime) {
        this.DeliveryTime = DeliveryTime;
    }

    /**
     *
     * @return
     *     The OpeningTime
     */
    public String getOpeningTime() {
        return OpeningTime;
    }

    /**
     *
     * @param OpeningTime
     *     The OpeningTime
     */
    public void setOpeningTime(String OpeningTime) {
        this.OpeningTime = OpeningTime;
    }

    /**
     *
     * @return
     *     The OpeningTimeIso
     */
    public String getOpeningTimeIso() {
        return OpeningTimeIso;
    }

    /**
     *
     * @param OpeningTimeIso
     *     The OpeningTimeIso
     */
    public void setOpeningTimeIso(String OpeningTimeIso) {
        this.OpeningTimeIso = OpeningTimeIso;
    }

    /**
     *
     * @return
     *     The SendsOnItsWayNotifications
     */
    public Boolean getSendsOnItsWayNotifications() {
        return SendsOnItsWayNotifications;
    }

    /**
     *
     * @param SendsOnItsWayNotifications
     *     The SendsOnItsWayNotifications
     */
    public void setSendsOnItsWayNotifications(Boolean SendsOnItsWayNotifications) {
        this.SendsOnItsWayNotifications = SendsOnItsWayNotifications;
    }

    /**
     *
     * @return
     *     The RatingAverage
     */
    public Double getRatingAverage() {
        return RatingAverage;
    }

    /**
     *
     * @param RatingAverage
     *     The RatingAverage
     */
    public void setRatingAverage(Double RatingAverage) {
        this.RatingAverage = RatingAverage;
    }

    /**
     *
     * @return
     *     The Latitude
     */
    public Double getLatitude() {
        return Latitude;
    }

    /**
     *
     * @param Latitude
     *     The Latitude
     */
    public void setLatitude(Double Latitude) {
        this.Latitude = Latitude;
    }

    /**
     *
     * @return
     *     The Longitude
     */
    public Double getLongitude() {
        return Longitude;
    }

    /**
     *
     * @param Longitude
     *     The Longitude
     */
    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
    }

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
     *     The Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     *
     * @param Address
     *     The Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     *
     * @return
     *     The Postcode
     */
    public String getPostcode() {
        return Postcode;
    }

    /**
     *
     * @param Postcode
     *     The Postcode
     */
    public void setPostcode(String Postcode) {
        this.Postcode = Postcode;
    }

    /**
     *
     * @return
     *     The City
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @param City
     *     The City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * @return
     *     The CuisineTypes
     */
    public List<CuisineType> getCuisineTypes() {
        return CuisineTypes;
    }

    /**
     *
     * @param CuisineTypes
     *     The CuisineTypes
     */
    public void setCuisineTypes(List<CuisineType> CuisineTypes) {
        this.CuisineTypes = CuisineTypes;
    }

    /**
     *
     * @return
     *     The Url
     */
    public String getUrl() {
        return Url;
    }

    /**
     *
     * @param Url
     *     The Url
     */
    public void setUrl(String Url) {
        this.Url = Url;
    }

    /**
     *
     * @return
     *     The IsOpenNow
     */
    public Boolean getIsOpenNow() {
        return IsOpenNow;
    }

    /**
     *
     * @param IsOpenNow
     *     The IsOpenNow
     */
    public void setIsOpenNow(Boolean IsOpenNow) {
        this.IsOpenNow = IsOpenNow;
    }

    /**
     *
     * @return
     *     The IsSponsored
     */
    public Boolean getIsSponsored() {
        return IsSponsored;
    }

    /**
     *
     * @param IsSponsored
     *     The IsSponsored
     */
    public void setIsSponsored(Boolean IsSponsored) {
        this.IsSponsored = IsSponsored;
    }

    /**
     *
     * @return
     *     The IsNew
     */
    public Boolean getIsNew() {
        return IsNew;
    }

    /**
     *
     * @param IsNew
     *     The IsNew
     */
    public void setIsNew(Boolean IsNew) {
        this.IsNew = IsNew;
    }

    /**
     *
     * @return
     *     The IsTemporarilyOffline
     */
    public Boolean getIsTemporarilyOffline() {
        return IsTemporarilyOffline;
    }

    /**
     *
     * @param IsTemporarilyOffline
     *     The IsTemporarilyOffline
     */
    public void setIsTemporarilyOffline(Boolean IsTemporarilyOffline) {
        this.IsTemporarilyOffline = IsTemporarilyOffline;
    }

    /**
     *
     * @return
     *     The ReasonWhyTemporarilyOffline
     */
    public String getReasonWhyTemporarilyOffline() {
        return ReasonWhyTemporarilyOffline;
    }

    /**
     *
     * @param ReasonWhyTemporarilyOffline
     *     The ReasonWhyTemporarilyOffline
     */
    public void setReasonWhyTemporarilyOffline(String ReasonWhyTemporarilyOffline) {
        this.ReasonWhyTemporarilyOffline = ReasonWhyTemporarilyOffline;
    }

    /**
     *
     * @return
     *     The UniqueName
     */
    public String getUniqueName() {
        return UniqueName;
    }

    /**
     *
     * @param UniqueName
     *     The UniqueName
     */
    public void setUniqueName(String UniqueName) {
        this.UniqueName = UniqueName;
    }

    /**
     *
     * @return
     *     The IsCloseBy
     */
    public Boolean getIsCloseBy() {
        return IsCloseBy;
    }

    /**
     *
     * @param IsCloseBy
     *     The IsCloseBy
     */
    public void setIsCloseBy(Boolean IsCloseBy) {
        this.IsCloseBy = IsCloseBy;
    }

    /**
     *
     * @return
     *     The IsHalal
     */
    public Boolean getIsHalal() {
        return IsHalal;
    }

    /**
     *
     * @param IsHalal
     *     The IsHalal
     */
    public void setIsHalal(Boolean IsHalal) {
        this.IsHalal = IsHalal;
    }

    /**
     *
     * @return
     *     The DefaultDisplayRank
     */
    public Integer getDefaultDisplayRank() {
        return DefaultDisplayRank;
    }

    /**
     *
     * @param DefaultDisplayRank
     *     The DefaultDisplayRank
     */
    public void setDefaultDisplayRank(Integer DefaultDisplayRank) {
        this.DefaultDisplayRank = DefaultDisplayRank;
    }

    /**
     *
     * @return
     *     The IsOpenNowForDelivery
     */
    public Boolean getIsOpenNowForDelivery() {
        return IsOpenNowForDelivery;
    }

    /**
     *
     * @param IsOpenNowForDelivery
     *     The IsOpenNowForDelivery
     */
    public void setIsOpenNowForDelivery(Boolean IsOpenNowForDelivery) {
        this.IsOpenNowForDelivery = IsOpenNowForDelivery;
    }

    /**
     *
     * @return
     *     The IsOpenNowForCollection
     */
    public Boolean getIsOpenNowForCollection() {
        return IsOpenNowForCollection;
    }

    /**
     *
     * @param IsOpenNowForCollection
     *     The IsOpenNowForCollection
     */
    public void setIsOpenNowForCollection(Boolean IsOpenNowForCollection) {
        this.IsOpenNowForCollection = IsOpenNowForCollection;
    }

    /**
     *
     * @return
     *     The RatingStars
     */
    public Double getRatingStars() {
        return RatingStars;
    }

    /**
     *
     * @param RatingStars
     *     The RatingStars
     */
    public void setRatingStars(Double RatingStars) {
        this.RatingStars = RatingStars;
    }

    /**
     *
     * @return
     *     The Logo
     */
    public List<myapp.tae.ac.uk.justeattest.Model.Logo> getLogo() {
        return Logo;
    }

    /**
     *
     * @param Logo
     *     The Logo
     */
    public void setLogo(List<myapp.tae.ac.uk.justeattest.Model.Logo> Logo) {
        this.Logo = Logo;
    }

    /**
     *
     * @return
     *     The Deals
     */
    public List<Object> getDeals() {
        return Deals;
    }

    /**
     *
     * @param Deals
     *     The Deals
     */
    public void setDeals(List<Object> Deals) {
        this.Deals = Deals;
    }

    /**
     *
     * @return
     *     The NumberOfRatings
     */
    public Integer getNumberOfRatings() {
        return NumberOfRatings;
    }

    /**
     *
     * @param NumberOfRatings
     *     The NumberOfRatings
     */
    public void setNumberOfRatings(Integer NumberOfRatings) {
        this.NumberOfRatings = NumberOfRatings;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(Badges);
        dest.writeValue(Score);
        dest.writeValue(DriveDistance);
        dest.writeValue(DriveInfoCalculated);
        dest.writeValue(NewnessDate);
        dest.writeValue(DeliveryMenuId);
        dest.writeValue(DeliveryOpeningTime);
        dest.writeValue(DeliveryCost);
        dest.writeValue(MinimumDeliveryValue);
        dest.writeValue(DeliveryTime);
        dest.writeValue(OpeningTime);
        dest.writeValue(OpeningTimeIso);
        dest.writeValue(SendsOnItsWayNotifications);
        dest.writeValue(RatingAverage);
        dest.writeValue(Latitude);
        dest.writeValue(Longitude);
        dest.writeValue(Id);
        dest.writeValue(Name);
        dest.writeValue(Address);
        dest.writeValue(Postcode);
        dest.writeValue(City);
        dest.writeList(CuisineTypes);
        dest.writeValue(Url);
        dest.writeValue(IsOpenNow);
        dest.writeValue(IsSponsored);
        dest.writeValue(IsNew);
        dest.writeValue(IsTemporarilyOffline);
        dest.writeValue(ReasonWhyTemporarilyOffline);
        dest.writeValue(UniqueName);
        dest.writeValue(IsCloseBy);
        dest.writeValue(IsHalal);
        dest.writeValue(DefaultDisplayRank);
        dest.writeValue(IsOpenNowForDelivery);
        dest.writeValue(IsOpenNowForCollection);
        dest.writeValue(RatingStars);
        dest.writeList(Logo);
        dest.writeList(Deals);
        dest.writeValue(NumberOfRatings);
    }

    public int describeContents() {
        return  0;
    }

}
