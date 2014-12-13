package demo.orika.test.domain;


import com.google.common.base.MoreObjects;

public class Simple {
    private Integer number;
    private String name;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("number", this.getNumber())
                .add("name", this.getName())
                .add("noName", this.getNoName())
                .toString();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoName() {
        return noName;
    }

    public void setNoName(String noName) {
        this.noName = noName;
    }

    private String noName;
}
