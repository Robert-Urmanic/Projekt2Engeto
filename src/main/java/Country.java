import java.math.BigDecimal;
import java.util.Comparator;

public class Country{
    private String country;
    private BigDecimal standard_rate;
    private String reduced_rate;
    private String reduced_rate_alt;
    private String super_reduced_rate;
    private String parking_rate;
    private String abbreviation;
    private String _comment;
    private String iso_duplicate_of;
    private String iso_duplicate;

    public String get_comment() {
        return _comment;
    }

    public void set_comment(String _comment) {
        this._comment = _comment;
    }

    public String getIso_duplicate_of() {
        return iso_duplicate_of;
    }

    public void setIso_duplicate_of(String iso_duplicate_of) {
        this.iso_duplicate_of = iso_duplicate_of;
    }

    public String getIso_duplicate() {
        return iso_duplicate;
    }

    public void setIso_duplicate(String iso_duplicate) {
        this.iso_duplicate = iso_duplicate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getStandard_rate() {
        return standard_rate;
    }

    public void setStandard_rate(BigDecimal standard_rate) {
        this.standard_rate = standard_rate;
    }

    public String getReduced_rate() {
        return reduced_rate;
    }

    public void setReduced_rate(String reduced_rate) {
        this.reduced_rate = reduced_rate;
    }

    public String getReduced_rate_alt() {
        return reduced_rate_alt;
    }

    public void setReduced_rate_alt(String reduced_rate_alt) {
        this.reduced_rate_alt = reduced_rate_alt;
    }

    public String getSuper_reduced_rate() {
        return super_reduced_rate;
    }

    public void setSuper_reduced_rate(String super_reduced_rate) {
        this.super_reduced_rate = super_reduced_rate;
    }

    public String getParking_rate() {
        return parking_rate;
    }

    public void setParking_rate(String parking_rate) {
        this.parking_rate = parking_rate;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", standard_rate=" + standard_rate +
                ", reduced_rate='" + reduced_rate + '\'' +
                ", reduced_rate_alt='" + reduced_rate_alt + '\'' +
                ", super_reduced_rate='" + super_reduced_rate + '\'' +
                ", parking_rate='" + parking_rate + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", _comment='" + _comment + '\'' +
                ", iso_duplicate_of='" + iso_duplicate_of + '\'' +
                ", iso_duplicate='" + iso_duplicate + '\'' +
                '}';
    }
}
