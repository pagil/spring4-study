package demo.orika.test.domain;

import com.google.common.base.MoreObjects;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class Customer {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormat.forPattern("yyyyMMdd");
    private Long id;
    private String name;
    private String address;
    private Date date;
    private DateTime dateTime;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.getId())
                .add("name", this.getName())
                .add("address", this.getAddress())
                .add("date", dateTime != null ? dateTime.toString(FORMATTER) : "null")
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
