package demo.orika.test.dto;

import com.google.common.base.MoreObjects;

public class SimpleDTO {
    private Integer id;
    private String name;
    private String noName;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.getId())
                .add("name", this.getName())
                .add("noName", this.getNoName())
                .toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
