package DeserilaztionPojo;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FindStatusPojo {

    private  Map<String, Object> id;
    private  Map<String, Object>photoUrls;
    private   Map<String, Object> tags;
    private   Map<String, Object> status;

    public Map<String, Object> getId() {
        return id;
    }

    public void setId(Map<String, Object> id) {
        this.id = id;
    }

    public Map<String, Object> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(Map<String, Object> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getStatus() {
        return status;
    }

    public void setStatus(Map<String, Object> status) {
        this.status = status;
    }
}
